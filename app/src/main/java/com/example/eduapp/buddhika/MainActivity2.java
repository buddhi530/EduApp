package com.example.eduapp.buddhika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eduapp.R;
import com.example.eduapp.kavishka.Pp;
import com.example.eduapp.rasuni.Marks;
import com.example.eduapp.yasasri.Project;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDot;
    private Button btnEqual;
    private Button btnDel;
    private Button btnAc;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private TextView Info;
    private TextView Result;
    private final char plus = '+';
    private final char min = '-';
    private final char mul = '*';
    private final char div = '/';
    private final char EQU = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setupUIViews();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info.setText(Info.getText().toString() + "9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = plus;
                Result.setText(String.valueOf(val1) + "+");
                Info.setText(null);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = min;
                Result.setText(String.valueOf(val1) + "-");
                Info.setText(null);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = mul;
                Result.setText(String.valueOf(val1) + "*");
                Info.setText(null);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = div;
                Result.setText(String.valueOf(val1) + "/");
                Info.setText(null);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQU;
                Result.setText(Result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                //5+4=9
                Info.setText(null);
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Info.getText().length() > 0) {
                    CharSequence name = Info.getText().toString();
                    Info.setText(name.subSequence(0, name.length() - 1));
                } else {

                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    Info.setText(null);
                    Result.setText(null);
                }
            }


        });
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Info.getText().length() > 0) {
                    CharSequence name = Info.getText().toString();
                    Info.setText(name.subSequence(0, name.length() - 1));
                } else {

                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    Info.setText(null);
                    Result.setText(null);
                }
            }
        });
    }




    private void setupUIViews(){
        btn0=(Button)findViewById(R.id.zero);
        btn1=(Button)findViewById(R.id.one);
        btn2=(Button)findViewById(R.id.two);
        btn3=(Button)findViewById(R.id.three);
        btn4=(Button)findViewById(R.id.four);
        btn5=(Button)findViewById(R.id.five);
        btn6=(Button)findViewById(R.id.six);
        btn7=(Button)findViewById(R.id.seven);
        btn8=(Button)findViewById(R.id.eight);
        btn9=(Button)findViewById(R.id.nine);
        btnDot=(Button) findViewById(R.id.point);
        btnEqual=(Button) findViewById(R.id.equal);
        btnDel=(Button)findViewById(R.id.back);
        btnAc=(Button)findViewById(R.id.ac);
        btnAdd=(Button)findViewById(R.id.plus);
        btnSub=(Button)findViewById(R.id.min);
        btnMul=(Button)findViewById(R.id.mul);
        btnDiv=(Button)findViewById(R.id.div);
        Info =(TextView) findViewById(R.id.info);
        Result =(TextView)findViewById(R.id.result);



        //intialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.todo);

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
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(Info.getText().toString()) ;
            switch (ACTION){
                case plus:
                    val1=val1+val2;
                    break;
                case min :
                    val1=val1-val2;
                    break;
                case mul :
                    val1=val1*val2;
                    break;
                case div :
                    val1=val1/val2;
                    break;
                case EQU:
                    break;

            }
        }
        else{
            val1 = Double.parseDouble(Info.getText().toString());
        }

    }

}












