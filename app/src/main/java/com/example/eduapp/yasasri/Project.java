package com.example.eduapp.yasasri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.eduapp.buddhika.Assignment;

import com.example.eduapp.buddhika.MainActivity2;
import com.example.eduapp.kavishka.Pp;
import com.example.eduapp.R;
import com.example.eduapp.rasuni.Marks;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Project extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);


        button = (Button) findViewById(R.id.view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Project.this, Edit_project.class);
                startActivity(intent);
            }
        });






        //intialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.project);

        //perform itemselected list
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.project:
                        return true;
                    case R.id.todo:
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.assignment:
                        startActivity(new Intent(getApplicationContext(), Assignment.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.marks:
                        startActivity(new Intent(getApplicationContext(), Marks.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.pp:
                        startActivity(new Intent(getApplicationContext(), Pp.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });

    }
}