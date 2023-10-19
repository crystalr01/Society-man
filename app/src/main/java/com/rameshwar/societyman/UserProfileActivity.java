package com.rameshwar.societyman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {


    private TextView userEmailTextView, userUIDTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userEmailTextView = findViewById(R.id.userEmailTextView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            userEmailTextView.setText(String.format("Email: %s", user.getEmail()));
            userUIDTextView.setText(String.format("Password: %s", user.getUid()));
            // Get other details as needed
        } else {
            // Handle the case where user data is not available
            finish();
        }
    }
}