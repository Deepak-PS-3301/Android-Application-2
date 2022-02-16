package com.example.studentdbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {
EditText edt1,edt2,edt3,edt4;
String getName,getAdmissionNo,getRollNo,getCollege;
AppCompatButton btn1,btn2;
DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper=new DatabaseHelper(this);
        dbHelper.getWritableDatabase();
        setContentView(R.layout.activity_add_student);
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        edt3=(EditText) findViewById(R.id.edt3);
        edt4=(EditText) findViewById(R.id.edt4);
        btn1=(AppCompatButton) findViewById(R.id.btn1);
        btn2=(AppCompatButton) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=edt1.getText().toString();
                getAdmissionNo=edt2.getText().toString();
                getRollNo=edt3.getText().toString();
                getCollege=edt4.getText().toString();
                boolean result= dbHelper.InsertData(getName,getRollNo,getAdmissionNo,getCollege);
                if (result==true){
                    edt1.setText("");
                    edt2.setText("");
                    edt3.setText("");
                    edt4.setText("");
                    Toast.makeText(getApplicationContext(), "Sucessfully Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Failed To Insert Data..!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}