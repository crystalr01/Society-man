package com.rameshwar.societyman.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.rameshwar.societyman.R;
import com.rameshwar.societyman.UsersList;

public class ProfileF extends Fragment {

    public ProfileF() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(inflater.getContext(),R.layout.fragment_profile,null);



        return view;
    }


}