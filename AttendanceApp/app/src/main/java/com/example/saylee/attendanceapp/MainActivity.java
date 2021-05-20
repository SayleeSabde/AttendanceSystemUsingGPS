package com.example.saylee.attendanceapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button teacher,student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
             teacher = (Button)findViewById(R.id.btnTeacher);
             student = (Button)findViewById(R.id.btnStudent);
             teacher.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent i1 = new Intent(getApplicationContext(),TeacherLogin.class);
                     startActivity(i1);
                 }
             });

    }

}
