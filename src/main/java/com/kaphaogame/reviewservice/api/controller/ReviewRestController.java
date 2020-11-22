package com.kaphaogame.reviewservice.api.controller;

import com.kaphaogame.reviewservice.api.model.Review;
import com.kaphaogame.reviewservice.api.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/review")
public class ReviewRestController {
    ReviewRepository reviewRepository;

    public ReviewRestController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public List<Review> getAllReview() throws ExecutionException, InterruptedException {
        return reviewRepository.getAllComments();
    }

    @PostMapping
    public Review createReview(Review review) {
        return reviewRepository.createComment(review);
    }

    @PutMapping
    public Review editReview(Review review) {
        return reviewRepository.editComment(review);
    }

    @DeleteMapping("/{gameTag}_{username}")
    public void deleteReview(Review review) {
        reviewRepository.deleteComment(review);
    }

    @GetMapping("/{gameTag}")
    public List<Review> getAllReviewByGameTag(@PathVariable String gameTag) throws ExecutionException, InterruptedException {
        return reviewRepository.getAllCommentsByGameTag(gameTag);
    }


}
