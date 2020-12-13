package com.example.eduapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eduapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout rusername ,remail,rphone ,rpwd;
    Button regbtn,logbtn;

    FirebaseDatabase rootNo;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rusername = findViewById(R.id.username);
        remail = findViewById(R.id.email);
        rphone = findViewById(R.id.phone);
        rpwd = findViewById(R.id.passowrd);
        regbtn = findViewById(R.id.reg_btn);
        logbtn = findViewById(R.id.reg_login_btn);



        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNo = FirebaseDatabase.getInstance();
                reference = rootNo.getReference( "login");



                try {


                    //get all the values
                    String name = rusername.getEditText().getText().toString();
                    String password = rpwd.getEditText().getText().toString();
                    String email = remail.getEditText().getText().toString();
                    String phone = rphone.getEditText().getText().toString();


                    UserHelperClass userHelperClass = new UserHelperClass(name,password,email,phone);
                    reference.child(phone).setValue(userHelperClass);
                }
                catch (Exception e)
                {
                    System.out.println("error");
                }
            }
        });



    }

    private boolean validatename()
    {
        String val = rusername.getEditText().getText().toString();
        if(val.isEmpty())
        {
            rusername.setError("Field cannot be empty");
            return false;
        }
        else
        {
            rusername.setError(null);
            return true;
        }
    }

    private boolean validateemail() {
        String val = remail.getEditText().getText().toString();
        String emilptrn = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            remail.setError("Field cannot be empty");
            return false;
        }
        else if (!val.matches(emilptrn) )
        {
            remail.setError("Invalid email address");
            return false;
        }

        else
        {
            remail.setError(null);
            return true;
        }
    }

    private boolean validatphone()
    {
        String val = rphone.getEditText().getText().toString();
        if(val.isEmpty())
        {
            rphone.setError("Field cannot be empty");
            return false;
        }
        else
        {
            rphone.setError(null);
            return true;
        }
    }

    private boolean validatepwd()
    {
        String val = rpwd.getEditText().getText().toString();
        if(val.isEmpty())
        {
            rpwd.setError("Field cannot be empty");
            return false;
        }
        else
        {
            rpwd.setError(null);
            return true;
        }
    }






}