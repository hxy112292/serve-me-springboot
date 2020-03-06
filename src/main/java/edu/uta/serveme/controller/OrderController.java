package edu.uta.serveme.controller;

import com.google.common.base.Preconditions;
import com.sun.org.apache.xpath.internal.operations.Or;
import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.constant.ErrorMessage;
import edu.uta.serveme.entity.Order;
import edu.uta.serveme.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/findOrderByCustomer")
    public BaseResponse<List<Order>> findOrderByCustomer(@RequestParam("customerId") Integer customerId) {

        Preconditions.checkNotNull(customerId, ErrorMessage.ACCOUNT_NOT_FOUND);

        Order order = new Order();
        order.setCustomerId(customerId);

        return new ResultResponse<>(orderService.findOrderBySelective(order));
    }

    @GetMapping(value = "/findOrderByVendor")
    public BaseResponse<List<Order>> findOrderByVendor(@RequestParam("vendorId") Integer vendorId) {

        Preconditions.checkNotNull(vendorId, ErrorMessage.ACCOUNT_NOT_FOUND);

        Order order = new Order();
        order.setVendorId(vendorId);

        return new ResultResponse<>(orderService.findOrderBySelective(order));
    }

    @GetMapping(value = "/findBidByVendor")
    public BaseResponse<List<Order>> findBidByVendor(@RequestParam("city") String city, @RequestParam("serviceType") String serviceType) {

        Order order = new Order();
        order.setCity(city);
        order.setServiceType(serviceType);
        order.setStatus(Constant.ORDER_STATUS_BIDING);

        return new ResultResponse<>(orderService.findOrderBySelective(order));
    }

    @PostMapping(value = "/insert")
    public BaseResponse<Integer> insertOrder(@RequestBody Order order) {

        return new ResultResponse<>(orderService.insertOrder(order));
    }

    @PutMapping(value = "/update")
    public BaseResponse<Integer> updateOrder(@RequestBody Order order) {

        return new ResultResponse<>(orderService.updateOrder(order));
    }

    @DeleteMapping(value = "/delete")
    public BaseResponse<Integer> deleteOrder(@RequestParam("id") Integer id) {

        return new ResultResponse<>(orderService.deleteOrder(id));
    }

    @GetMapping(value = "/findOrderById")
    public BaseResponse<Order> findOrderById(@RequestParam("id") Integer id) {

        return new ResultResponse<>(orderService.findOrderById(id));
    }
}
