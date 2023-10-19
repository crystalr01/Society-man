package com.rameshwar.societyman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rameshwar.societyman.Fragments.Admin;
import com.rameshwar.societyman.Fragments.Home;
import com.rameshwar.societyman.Fragments.Notifications;
import com.rameshwar.societyman.Fragments.ProfileF;
import com.rameshwar.societyman.Fragments.Users;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new Home()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                int id = item.getItemId();

                if(id == R.id.nav_home){
                    fragment = new Home();
                } else if (id == R.id.nav_users) {
                    fragment = new Users();
                } else if (id == R.id.nav_notifications) {
                    fragment = new Notifications();
                } else if (id == R.id.nav_admin) {
                    fragment = new Admin();
                } else {
                    fragment = new ProfileF();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();

                return true;
            }
        });

    }
}