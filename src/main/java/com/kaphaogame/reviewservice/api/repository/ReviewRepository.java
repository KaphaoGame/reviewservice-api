package com.kaphaogame.reviewservice.api.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.kaphaogame.reviewservice.api.FirebaseInitializer;
import com.kaphaogame.reviewservice.api.model.Review;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class ReviewRepository {
    private FirebaseInitializer db;

    private List<Review> reviewList;

    public ReviewRepository() throws IOException, ExecutionException, InterruptedException {
        reviewList = new ArrayList<>();
        db = new FirebaseInitializer();

        CollectionReference review = db.getFirestore().collection("Comment");
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = review.get();
        for(DocumentSnapshot documentSnapshot: querySnapshotApiFuture.get().getDocuments()){
            Review reviewQuery = documentSnapshot.toObject(Review.class);
            reviewList.add(reviewQuery);
        }
    }

    public List<Review> getAllComments() {
        return reviewList;
    }

    public Review createComment(Review review) {
        Review reviewRegistering = new Review(review.getUsername(), review.getGameName(), review.getGameTag(), review.getStory()
                                                ,review.getGameplay(), review.getGraphic(), review.getPerformance(), review.getSound()
                                                ,review.getComments());
        ApiFuture<DocumentReference> resultApiFuture = db.getFirestore().collection("Comment").add(reviewRegistering);
        reviewList.add(reviewRegistering);
        return reviewRegistering;
    }

    public List<Review> getAllCommentsByGameTag(String gameTag) {
        List<Review> comments = new ArrayList<>();
        for (Review comment: reviewList) {
            if (comment.getGameTag().equals(gameTag)){
                comments.add(comment);
            }
        }
        return comments;
    }


}
