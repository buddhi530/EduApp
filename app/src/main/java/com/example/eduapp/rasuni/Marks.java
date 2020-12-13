package com.example.eduapp.rasuni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduapp.buddhika.Assignment;
import com.example.eduapp.buddhika.MainActivity2;
import com.example.eduapp.kavishka.Pp;
import com.example.eduapp.R;
import com.example.eduapp.yasasri.Project;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Marks extends AppCompatActivity {

    private Button button;
    EditText year1,semester1,gpa1,mark1,subject1;
    Button add,btnDisplay;
    DatabaseReference myref;
    FirebaseDatabase firebaseDatabase;
    Result rslt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);

         year1 = findViewById(R.id.txt_year);
         semester1 = findViewById(R.id.txt_semester);
         gpa1 = findViewById(R.id.txt_gpa);
         mark1 = findViewById(R.id.txt_mark);
         subject1 = findViewById(R.id.txt_subject);

        add = findViewById(R.id.add);
        btnDisplay = findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Marks.this,RetrieveDataActivity.class));
            }
        });


        insertdata();




        //intialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.marks);

        //perform itemselected list
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.marks:
                        return true;
                    case R.id.todo:
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.assignment:
                        startActivity(new Intent(getApplicationContext(), Assignment.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.project:
                        startActivity(new Intent(getApplicationContext(), Project.class));
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

    private void insertdata() {


        firebaseDatabase = FirebaseDatabase.getInstance();
        myref = firebaseDatabase.getReference("Data");




                add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String year = year1.getText().toString();
                final String semester = semester1.getText().toString();
                final String gpa = gpa1.getText().toString();
                final String subject = subject1.getText().toString();
                final String mark = mark1.getText().toString();

                Result result = new Result(year,semester,gpa,mark,subject);

                clearcontrol();
                //add timestamp

                long mdatetime = 9999999999L - System.currentTimeMillis();
                String mordertime = String.valueOf(mdatetime);

                myref.child(mordertime).setValue(result).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Data Inserted Succesfuly!",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Failure Inserted Data!",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }

    private void clearcontrol()
    {
        subject1.setText("");
        semester1.setText("");
        year1.setText("");
        gpa1.setText("");
        mark1.setText("");


    }
}