package com.example.demotodolist;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {

    public String createTask(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture =
                dbFirestore.collection("todo_list").document(crud.getTask()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public CRUD getTask(String document_id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection("todo_list").document(CRUD.getTask()).get(document_id);
    }

    public String updateTask(CRUD crud){
        return "";
    }

    public String deleteTask(String document_id){
        return "";
    }
}
