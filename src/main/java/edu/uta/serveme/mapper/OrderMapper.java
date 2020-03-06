package edu.uta.serveme.mapper;

import edu.uta.serveme.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> findOrderBySelective(Order order);

    List<Order> findBidByVendor(int vendorId);

    List<Order> findBidByCustomer(int customerId);
}