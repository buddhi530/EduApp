package com.example.eduapp.buddhika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduapp.R;
import com.example.eduapp.kavishka.Pp;
import com.example.eduapp.rasuni.Marks;
import com.example.eduapp.yasasri.Project;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Assignment extends AppCompatActivity {


    private Button button;

    Button btn_upload1,btn_delete;
    EditText txt_year;
    EditText txt_semester;
    EditText txt_name1;
    EditText txt_subject;

    StorageReference storageReference;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);


        btn_upload1 = (Button) findViewById(R.id.ass_upload_btn);
        txt_year = (EditText) findViewById(R.id.ass_txt_year);
        txt_semester = (EditText) findViewById(R.id.ass_txt_semester);
        txt_name1 = (EditText) findViewById(R.id.ass_txt_name11);
        txt_subject = (EditText) findViewById(R.id.ass_txt_subject);


        button = (Button) findViewById(R.id.view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assignment.this, Edit_assignment.class);
                startActivity(intent);
            }
        });


//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                databaseReference.child("uploads").setValue(null);
//            }
//        });


        //intialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.assignment);

        //perform itemselected list
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.marks:
                        startActivity(new Intent(getApplicationContext(), Marks.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.todo:
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.assignment:

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


        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploadsAss");


        btn_upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectPDFFile();
            }
        });



    }


    private void selectPDFFile() {

        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF File"),1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK
                && data !=null && data.getData()!=null)
        {
            uploadPDFFile(data.getData());

        }

    }

    private void uploadPDFFile(Uri data) {

        final ProgressDialog processDialog = new ProgressDialog(this);
        processDialog.setTitle("Uploading...");
        processDialog.show();

        StorageReference reference = storageReference.child("uploadsAss/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while (!uri.isComplete());
                Uri url = uri.getResult();

                Upload_pdf Upload_pdf = new Upload_pdf(txt_name1.getText().toString(),url.toString());

                databaseReference.child(databaseReference.push().getKey()).setValue(Upload_pdf);

                Toast.makeText(Assignment.this,"File Upload",Toast.LENGTH_SHORT).show();
                processDialog.dismiss();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                double progress = (100.0 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                processDialog.setMessage("Uploaded:"+(int)progress+"%");

            }
        });


    }


    public void retrievePDF(View view) {

        startActivity(new Intent(getApplicationContext(),Edit_assignment.class));
    }
}

