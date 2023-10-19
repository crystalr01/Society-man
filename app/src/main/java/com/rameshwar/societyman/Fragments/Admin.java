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
import com.rameshwar.societyman.AdminMain;
import com.rameshwar.societyman.R;
import com.rameshwar.societyman.UsersList;

public class Admin extends Fragment {

    public Admin() {

    }

    TextInputEditText usernameEditText, passwordEditText;
    Button loginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin,container,false);

        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (isValid(username, password)) {

                    Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getContext(), AdminMain.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    usernameEditText.setError("Wrong Username");
                    passwordEditText.setError("Wrong password");
                }
            }
        });

        return  view;
    }

    private boolean isValid(String username, String password) {

        return "admin".equals(username) && "1234".equals(password);

    }
}