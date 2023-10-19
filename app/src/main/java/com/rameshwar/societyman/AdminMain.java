package com.rameshwar.societyman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminMain extends AppCompatActivity {

    Button uploadNotice,uploadUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        uploadNotice = findViewById(R.id.uploadNotice);
        uploadUser = findViewById(R.id.uploadUser);

        uploadNotice.setOnClickListener(v -> {
            Intent intent = new Intent(AdminMain.this,UpNotice.class);
            startActivity(intent);
        });

        uploadUser.setOnClickListener(v -> {
            Intent intent = new Intent(AdminMain.this,UploadUser.class);
            startActivity(intent);
        });
    }
}