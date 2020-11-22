package com.kaphaogame.reviewservice.api.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.kaphaogame.reviewservice.api.FirebaseInitializer;
import com.kaphaogame.reviewservice.api.model.Review;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class ReviewRepository {
    private FirebaseInitializer db;

    public ReviewRepository() throws IOException {
        db = new FirebaseInitializer();
    }

    public List<Review> getAllComments() throws ExecutionException, InterruptedException {
        List<Review> reviewList = new ArrayList<>();
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = db.getFirestore().collection("Comment").get();
        for(DocumentSnapshot documentSnapshot: querySnapshotApiFuture.get().getDocuments()){
            Review reviewQuery = documentSnapshot.toObject(Review.class);
            reviewList.add(reviewQuery);
        }
        return reviewList;
    }

    public Review createComment(Review review) {
        Review reviewRegistering = new Review(review.getUsername(), review.getGameName(), review.getGameTag(), review.getStory()
                                                ,review.getGameplay(), review.getGraphic(), review.getPerformance(), review.getSound()
                                                ,review.getComments());
        ApiFuture<WriteResult> resultApiFuture = db.getFirestore().collection("Comment").document(reviewRegistering.getGameTag()+"_"+reviewRegistering.getUsername()).set(reviewRegistering);
        return reviewRegistering;
    }

    public Review editComment(Review review) {
        Review reviewRegistering = new Review(review.getUsername(), review.getGameName(), review.getGameTag(), review.getStory()
                ,review.getGameplay(), review.getGraphic(), review.getPerformance(), review.getSound()
                ,review.getComments());
        ApiFuture<WriteResult> resultApiFuture = db.getFirestore().collection("Comment").document(reviewRegistering.getGameTag()+"_"+reviewRegistering.getUsername()).set(reviewRegistering);
        return reviewRegistering;
    }
    
    public void deleteComment(String gameTagAndUsername) {
        db.getFirestore().collection("Comment").document(gameTagAndUsername).delete();
    }

    public List<Review> getAllCommentsByGameTag(String gameTag) throws ExecutionException, InterruptedException {
        List<Review> comments = new ArrayList<>();
        List<Review> reviewList = getAllComments();
        for (Review comment: reviewList) {
            if (comment.getGameTag().equals(gameTag)){
                comments.add(comment);
            }
        }
        return comments;
    }


}
