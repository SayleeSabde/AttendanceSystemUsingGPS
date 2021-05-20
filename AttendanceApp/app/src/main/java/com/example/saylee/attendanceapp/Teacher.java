package com.example.saylee.attendanceapp;

/**
 * Created by Saylee on 08-05-2019.
 */

public class Teacher {
    private   String teacherId;
    private String Password123;

    public Teacher() {
    }

    public void setPassword123(String password) {
        this.Password123 = password;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getPassword123() {
        return Password123;
    }



}

