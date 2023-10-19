package com.rameshwar.societyman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    TextView profilename,profileemail;
    ImageView profileImage;
    Button logout;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        profilename = findViewById(R.id.profileName);
        profileemail = findViewById(R.id.profileEmail);
        profileImage = findViewById(R.id.profileImage);
        logout = findViewById(R.id.btnLogOut);

        user = FirebaseAuth.getInstance().getCurrentUser();

        profilename.setText(user.getDisplayName());
        profileemail.setText(user.getEmail());
        Glide.with(Profile.this).load(user.getPhotoUrl()).into(profileImage);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Profile.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Profile.this,MainActivity.class));
    }
}