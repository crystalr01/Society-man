package com.rameshwar.societyman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView noticeRecycler;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;
    private DatabaseReference reference;
    Button uploadUser;
    ImageView upImage;
    NavigationView navigationView;

    FirebaseUser user;

    private DatabaseReference reference1;
    private SliderAdapter sliderAdapter;
    private ArrayList<String> imageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upImage = findViewById(R.id.upimage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        upImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Admin.class);
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

                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                layoutManager.setReverseLayout(true);
                layoutManager.setStackFromEnd(true);

                noticeRecycler.setLayoutManager(layoutManager);
                adapter = new NoticeAdapter(MainActivity.this, list);
                noticeRecycler.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

        reference1 = FirebaseDatabase.getInstance().getReference().child("image_slider");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @SuppressLint("SuspiciousIndentation")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.profile){
            if (user!=null){
                startActivity(new Intent(MainActivity.this,Profile.class));
            } else
            startActivity(new Intent(MainActivity.this,Login.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }
}