package com.example.eduapp.rasuni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.eduapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrieveDataActivity extends AppCompatActivity {

    ListView myListView;
    List<Result> results;

    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data);

        myListView = findViewById(R.id.myListView);
        results = new ArrayList<>();

    myref = FirebaseDatabase.getInstance().getReference("Data");
    myref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            results.clear();

            for(DataSnapshot resultsnapshot : snapshot.getChildren())
            {
                Result re = resultsnapshot.getValue(Result.class);
                results.add(re);
            }

            ListAdapter adapter = new ListAdapter(RetrieveDataActivity.this,results);
            myListView.setAdapter(adapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

    }
}