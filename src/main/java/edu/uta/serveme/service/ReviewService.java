package edu.uta.serveme.service;

import edu.uta.serveme.entity.Review;

import java.util.List;

/**
 * @author hxy
 */
public interface ReviewService {

    List<Review> findReviewBySelective(Review review);

    int insertReview(Review review);
}
