package cc.yuanspace.springboot.integration.mybatis;

import cc.yuanspace.springboot.integration.mybatis.entity.UserDO;
import cc.yuanspace.springboot.integration.mybatis.mapper.UserMapper;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        UserDO userDO = userMapper.selectOne(1L);
        System.out.println(JSONUtil.toJsonStr(userDO));
        System.out.println(userDO.getCreateTime());
    }
}
