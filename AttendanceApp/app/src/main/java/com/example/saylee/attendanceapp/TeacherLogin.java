package com.example.saylee.attendanceapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherLogin extends AppCompatActivity {
    EditText tid, tpwd;
    Button tlogin;

    FirebaseDatabase db;
    DatabaseReference ref;
    TeacherLogin() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        tid = (EditText) findViewById(R.id.teacherId);
        tpwd = (EditText) findViewById(R.id.teacherPwd);
        tlogin = (Button)findViewById(R.id.btnlogin);
        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("Teacher_login");
        tlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(tid.getText().toString(),tpwd.getText().toString());
            }
        });
    }

    private void Login(final  String username, final  String password) {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(username).exists()) {
                    Toast.makeText(TeacherLogin.this, "Success1", Toast.LENGTH_SHORT).show();

                    if (!username.isEmpty()) {
                        if (!dataSnapshot.exists()) {
                            Toast.makeText(TeacherLogin.this, "Null datasnapshot", Toast.LENGTH_SHORT).show();

                        } else {
                            Teacher t = dataSnapshot.child(username).getValue(Teacher.class);

                            //Teacher t = new Teacher();
                            System.out.println(t);
                            tid.setText(t.getTeacherId());
                            if (t.getPassword123().equals(password)) {
                                Toast.makeText(TeacherLogin.this, "Success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(TeacherLogin.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(TeacherLogin.this, "Username not registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
   /* private void Login(final String username,final String passwd) {
        ref.child(username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Teacher t  = dataSnapshot
                if(passwd.equals(dataSnapshot.get))
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })
    }
*/
}
