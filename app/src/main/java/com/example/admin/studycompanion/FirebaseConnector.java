package com.example.admin.studycompanion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseConnector {
    private FirebaseAuth mauth;
    public static boolean worked = true;

    FirebaseConnector(Context context) {
        mauth = FirebaseAuth.getInstance();
        FirebaseApp app=FirebaseApp.initializeApp(context);
        Toast.makeText(context, app.getName(), Toast.LENGTH_SHORT).show();
    }

    public boolean signup(String email, String password) {
        mauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    worked = true;
                } else {
                    worked = false;
                }
            }
        });
        return worked;
    }

}
