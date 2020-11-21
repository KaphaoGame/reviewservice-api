package com.kaphaogame.reviewservice.api.controller;

import com.kaphaogame.reviewservice.api.model.Review;
import com.kaphaogame.reviewservice.api.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewRestController {
    ReviewRepository reviewRepository;

    public ReviewRestController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public List<Review> getAllReview() {return reviewRepository.getAllComments();}

    @PostMapping
    public Review createReview(Review review) {
        return reviewRepository.createComment(review);
    }

    @GetMapping("/{gameTag}")
    public List<Review> getAllReviewByGameTag(@PathVariable String gameTag){
        return reviewRepository.getAllCommentsByGameTag(gameTag);
    }


}
