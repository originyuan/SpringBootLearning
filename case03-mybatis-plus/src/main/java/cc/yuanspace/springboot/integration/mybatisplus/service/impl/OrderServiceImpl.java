package cc.yuanspace.springboot.integration.mybatisplus.service.impl;

import cc.yuanspace.springboot.integration.mybatisplus.entity.Order;
import cc.yuanspace.springboot.integration.mybatisplus.mapper.OrderMapper;
import cc.yuanspace.springboot.integration.mybatisplus.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author yy
 * @since 2022-06-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
