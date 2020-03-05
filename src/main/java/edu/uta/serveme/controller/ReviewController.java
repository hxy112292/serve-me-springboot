package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.Review;
import edu.uta.serveme.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(value = "/findReviewsByVendor")
    public BaseResponse<List<Review>> searchVendor(@RequestParam("vendorId") Integer vendorId, @RequestParam("serviceId") Integer serviceId) {

        Review review = new Review();
        review.setServiceId(serviceId);
        review.setVendorId(vendorId);

        return new ResultResponse<>(reviewService.findReviewBySelective(review));
    }

    @GetMapping(value = "/findReviewsByOrderId")
    public BaseResponse<Review> searchReviewByOrder(@RequestParam("orderId") Integer orderId) {

        Review review = new Review();
        review.setOrderId(orderId);

        List<Review> reviewList = reviewService.findReviewBySelective(review);
        if(reviewList != null && reviewList.size() != 0) {
            review = reviewList.get(0);
        }
        return new ResultResponse<>(review);
    }

    @PostMapping(value = "/insert")
    public BaseResponse<Integer> insertReview(@RequestBody Review review) {

        return new ResultResponse<>(reviewService.insertReview(review));
    }
}
