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

    @PostMapping(value = "/insert")
    public BaseResponse<Integer> insertReview(@RequestBody Review review) {

        return new ResultResponse<>(reviewService.insertReview(review));
    }
}
