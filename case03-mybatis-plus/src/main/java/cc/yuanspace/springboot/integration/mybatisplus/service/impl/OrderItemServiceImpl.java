package cc.yuanspace.springboot.integration.mybatisplus.service.impl;

import cc.yuanspace.springboot.integration.mybatisplus.entity.OrderItem;
import cc.yuanspace.springboot.integration.mybatisplus.mapper.OrderItemMapper;
import cc.yuanspace.springboot.integration.mybatisplus.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yy
 * @since 2022-06-08
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
