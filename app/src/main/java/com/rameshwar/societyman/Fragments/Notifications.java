package com.rameshwar.societyman.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rameshwar.societyman.NAdapter;
import com.rameshwar.societyman.NoticeAdapter;
import com.rameshwar.societyman.NoticeData;
import com.rameshwar.societyman.R;

import java.util.ArrayList;

public class Notifications extends Fragment {

    public Notifications() {
        // Required empty public constructor
    }

    private RecyclerView noticeRecycler;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NAdapter adapter;
    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications,container,false);

        reference = FirebaseDatabase.getInstance().getReference().child("notice");

        noticeRecycler = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    NoticeData data = snapshot1.getValue(NoticeData.class);
                    list.add(data);
                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setReverseLayout(true);
                layoutManager.setStackFromEnd(true);

                noticeRecycler.setLayoutManager(layoutManager);
                adapter = new NAdapter(getContext(), list);
                noticeRecycler.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}