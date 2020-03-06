package edu.uta.serveme.service;

import edu.uta.serveme.entity.Order;

import java.util.List;

/**
 * @author hxy
 */
public interface OrderService {

    int insertOrder(Order order);

    List<Order> findOrderBySelective(Order order);

    int updateOrder(Order order);

    int deleteOrder(int id);

    Order findOrderById(int id);

    List<Order> findBidByVendor(int vendorId);

    List<Order> findBidByCustomer(int customerId);
}
