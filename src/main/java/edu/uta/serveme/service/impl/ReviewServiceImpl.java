package edu.uta.serveme.service.impl;

import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.entity.Order;
import edu.uta.serveme.entity.Review;
import edu.uta.serveme.mapper.OrderMapper;
import edu.uta.serveme.mapper.ReviewMapper;
import edu.uta.serveme.service.ReviewService;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private final OrderMapper orderMapper;

    @Override
    public List<Review> findReviewBySelective(Review review) {
        return reviewMapper.findReviewBySelective(review);
    }

    @Override
    public int insertReview(Review review) {

        Order order = new Order();
        order.setId(review.getOrderId());
        order.setStatus(Constant.ORDER_STATUS_REVIEWED);
        orderMapper.updateByPrimaryKeySelective(order);

        review.setCreateTime(new Date());
        return reviewMapper.insert(review);
    }
}
