package cc.yuanspace.springboot.mybatis;

import cc.yuanspace.springboot.mybatis.entity.UserDO;
import cc.yuanspace.springboot.mybatis.mapper.UserMapper;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class TestCache {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     *
     * spring中每次查询都会创建一个新的SqlSession
     * 实际上是每个事务会创建一个SqlSession，而在没有开启事务的情况下，每条 mapper 语句都是一个独立事务
     * 如果想要一级缓存生效，可以开启事务
     *
     * 调整一级缓存级别为 statement 级别后，无论是否开启事务，缓存只对语句生效（等于关闭一级缓存）
     *
     * 一级缓存
     *   SqlSession 级别
     *   存入时机：
     *     查询数据库后，put到SqlSession的PerpetualCache本地缓存中
     *   失效时机：
     *     增删改操作
     *     事务提交、回滚
     *     主动调用刷新操作
     *     SqlSession关闭
     *
     * 二级缓存
     *   namesapce 级别缓存，多个 SqlSession 共享，默认关闭，需要手动开启
     *   存入时机：
     *     SqlSession关闭时，将一级缓存中的数据存入二级缓存
     *   失效时机：
     *     增删改操作提交
     *
     * 查询顺序为：先查二级缓存 -> 没有查一级缓存 -> 再没有查数据库 -> 将结果存入一级缓存 -> SqlSession关闭存入二级缓存
     *
     * 一二级缓存的刷新都是整个cache级别的，不是key-value级别
     */
    // 单元测试@TransActional注解会自动回滚，它会自动带有@Rollback(true)，
    //    如果需要修改数据库就不要使用@TransActional注解或者添加@Rollback(false)
//    @Transactional
//    @Rollback(false)
    @Test
    public void getUser() {
        UserDO userDO = userMapper.selectOne(1L);
        userMapper.selectOne(1L);
        userMapper.selectOne(1L);
        System.out.println(JSONUtil.toJsonPrettyStr(userDO));

        List<UserDO> userDOS = userMapper.listByGender(1);
        userDOS = userMapper.listByGender(1);
        System.out.println(JSONUtil.toJsonPrettyStr(userDOS));

        // 更新语句会导致一级缓存被清空，还没提交事务时已经清空了缓存
        userMapper.insert(UserDO.builder().username("marry").gender(2).build());

        userMapper.selectOne(1L);
        userMapper.selectOne(1L);
        userMapper.selectOne(1L);

        userDOS = userMapper.listByGender(1);
        System.out.println(JSONUtil.toJsonPrettyStr(userDOS));

    }


}
