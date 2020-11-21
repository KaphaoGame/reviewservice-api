package com.kaphaogame.reviewservice.api;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitializer {

    public FirebaseInitializer() throws IOException {
        this.initDB();
    }

    @PostConstruct
    private void initDB() throws IOException {
        InputStream serviceAccount = this.getClass().getClassLoader()
                .getResourceAsStream("kaphao-filebase-fd11c96f2f28.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://kaphao-filebase.firebaseio.com")
                .build();

        if (FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
        }
    }

    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

}
