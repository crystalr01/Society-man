package com.rameshwar.societyman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class UserInfo extends AppCompatActivity {

    ImageView userFullIamge;
    TextView userFullName;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userFullIamge = findViewById(R.id.userFull);

        url = getIntent().getStringExtra("newsImage");
        Glide.with(this).load(url).into(userFullIamge);

        userFullName = findViewById(R.id.userNameFull);

        String nameFull = getIntent().getStringExtra("userName");

        userFullName.setText(nameFull);

    }
}