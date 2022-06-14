package cc.yuanspace.springboot.mybatisplus;

import cc.yuanspace.springboot.mybatisplus.entity.Order;
import cc.yuanspace.springboot.mybatisplus.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private IOrderService orderService;
    @Test
    public void testInsert() {
        Order order = new Order();
        order.setOrderId(2L);
        order.setUserId(3L);
        boolean save = orderService.save(order);
        System.out.println(save);
    }
}
