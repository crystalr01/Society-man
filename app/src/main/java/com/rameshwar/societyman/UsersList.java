package com.rameshwar.societyman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UsersList extends AppCompatActivity {

    private RecyclerView noticeRecycler;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;
    private DatabaseReference reference;
    Button uploadUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        uploadUser = findViewById(R.id.uploadUsers);

        uploadUser.setOnClickListener(v -> {
            Intent intent = new Intent(UsersList.this,UploadUser.class);
            startActivity(intent);
        });

        reference = FirebaseDatabase.getInstance().getReference().child("users");

        noticeRecycler = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    NoticeData data = snapshot1.getValue(NoticeData.class);
                    list.add(data);
                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(UsersList.this);
                layoutManager.setReverseLayout(true);
                layoutManager.setStackFromEnd(true);

                noticeRecycler.setLayoutManager(layoutManager);
                adapter = new NoticeAdapter(UsersList.this, list);
                noticeRecycler.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(UsersList.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}