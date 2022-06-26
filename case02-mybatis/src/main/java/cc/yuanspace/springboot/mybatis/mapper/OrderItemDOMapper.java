package cc.yuanspace.springboot.mybatis.mapper;

import cc.yuanspace.springboot.mybatis.entity.OrderItemDO;
import cc.yuanspace.springboot.mybatis.entity.OrderItemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemDOMapper {
    long countByExample(OrderItemDOExample example);

    int deleteByExample(OrderItemDOExample example);

    int deleteByPrimaryKey(Long orderItemId);

    int insert(OrderItemDO record);

    int insertSelective(OrderItemDO record);

    List<OrderItemDO> selectByExample(OrderItemDOExample example);

    OrderItemDO selectByPrimaryKey(Long orderItemId);

    int updateByExampleSelective(@Param("record") OrderItemDO record, @Param("example") OrderItemDOExample example);

    int updateByExample(@Param("record") OrderItemDO record, @Param("example") OrderItemDOExample example);

    int updateByPrimaryKeySelective(OrderItemDO record);

    int updateByPrimaryKey(OrderItemDO record);
}