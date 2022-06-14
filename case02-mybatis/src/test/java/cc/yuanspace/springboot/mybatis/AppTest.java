package cc.yuanspace.springboot.mybatis;

import cc.yuanspace.springboot.mybatis.entity.OrderDO;
import cc.yuanspace.springboot.mybatis.entity.OrderDOExample;
import cc.yuanspace.springboot.mybatis.entity.UserDO;
import cc.yuanspace.springboot.mybatis.mapper.OrderDOMapper;
import cc.yuanspace.springboot.mybatis.mapper.UserMapper;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Test
    public void testOrder() {
        OrderDOExample orderDOExample = new OrderDOExample();
        OrderDOExample.Criteria criteria = orderDOExample.createCriteria();
        criteria.andOrderIdEqualTo(1L);

        OrderDOExample.Criteria or = orderDOExample.or();
        or.andOrderIdEqualTo(2L);

        OrderDOExample.Criteria criteria1 = orderDOExample.createCriteria();
        criteria1.andOrderIdEqualTo(3L);

        orderDOExample.or(criteria1);

        List<OrderDO> orderDOS = orderDOMapper.selectByExample(orderDOExample);

        System.out.println(JSONUtil.toJsonStr(orderDOS));
    }
}
