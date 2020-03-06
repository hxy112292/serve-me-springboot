package edu.uta.serveme.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.entity.Order;
import edu.uta.serveme.entity.Point;
import edu.uta.serveme.mapper.OrderMapper;
import edu.uta.serveme.mapper.PointMapper;
import edu.uta.serveme.service.FcmService;
import edu.uta.serveme.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final PointMapper pointMapper;
    private final FcmService fcmService;

    @Override
    public int insertOrder(Order order) {

        order.setCreateTime(new Date());
        orderMapper.insert(order);

        pointCal(order, Constant.POINT_PLACE_ORDER, 10);

        if(order.getStatus() == Constant.ORDER_STATUS_NOT_ACCEPTED) {
            fcmService.sendNotification(order.getVendorId(), "New Order", "You have a new order#" + order.getId());
        }

        return order.getId();
    }

    @Override
    public List<Order> findOrderBySelective(Order order) {
        return orderMapper.findOrderBySelective(order);
    }

    @Override
    public int updateOrder(Order order) {
        order.setUpdateTime(new Date());

        if(order.getStatus() != null) {
            if(order.getStatus().equals(Constant.ORDER_STATUS_CANCELED)) {
                pointCal(order, Constant.POINT_CANCEL_ORDER, -10);
                fcmService.sendNotification(order.getVendorId(), "Order Cancel", "Your order#" + order.getId()
                        + " has been canceled");
                fcmService.sendNotification(order.getCustomerId(), "Order Cancel", "Your order#" + order.getId()
                        + " has been canceled");
            } else if(order.getStatus().equals(Constant.ORDER_STATUS_PROCESSING)) {
                fcmService.sendNotification(order.getCustomerId(), "Order Accepted", "Your order#" + order.getId()
                        + " has been accepted");
            } else if(order.getStatus().equals(Constant.ORDER_STATUS_FINISHED)) {
                fcmService.sendNotification(order.getCustomerId(), "Order Finished", "Your order#" + order.getId()
                        + " has been finished");
            }
        }
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int deleteOrder(int id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Order findOrderById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    private void pointCal(Order order, String reason, Integer pointNum) {
        Point point = new Point();
        point.setUserId(order.getCustomerId());
        Map<String, Object> placeOrder = new HashMap<>();
        placeOrder.put("reason", reason);
        placeOrder.put("orderId", order.getId());
        point.setReason(JSONObject.toJSONString(placeOrder));
        point.setPoint(pointNum);
        point.setCreateTime(new Date());
        pointMapper.insert(point);
    }

    @Override
    public List<Order> findBidByVendor(int vendorId) {
        return orderMapper.findBidByVendor(vendorId);
    }
}
