package com.example.eduapp.kavishka;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eduapp.R;
import com.example.eduapp.kavishka.Upload_pdf;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Edit_pp extends AppCompatActivity {


    ListView mListView;

    DatabaseReference databaseReference;
    List<Upload_pdf> uploadedPDF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pp);


        mListView  = findViewById(R.id.listView);


        uploadedPDF  = new ArrayList<>();

        retrievePDFFiles();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Upload_pdf  upload_pdf = uploadedPDF.get(i);

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setType("application/pdf");
                intent.setData(Uri.parse(upload_pdf.getUrl()));
                startActivity(intent);
            }
        });




    }

    private void retrievePDFFiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("uploadspp");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot ds : snapshot.getChildren())
                {
                    com.example.eduapp.kavishka.Upload_pdf Upload_pdf = ds.getValue(com.example.eduapp.kavishka.Upload_pdf.class);
                    uploadedPDF.add(Upload_pdf);
                }

                String [] uploadsname = new String [uploadedPDF.size()];

                for (int i =0;i<uploadsname.length;i++)
                {
                    uploadsname[i] = uploadedPDF.get(i).getName();
                }
                ArrayAdapter<String> arrayAdapter  = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploadsname)
                {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);
                        TextView textView = (TextView) view.findViewById(android.R.id.text1);


                        textView.setTextColor(Color.BLACK);
                        textView.setTextSize(20);

                        return view;
                    }
                };
                mListView.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("error here");
            }
        });

    }


}