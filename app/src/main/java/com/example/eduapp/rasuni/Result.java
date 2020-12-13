package com.example.eduapp.rasuni;

import android.content.Intent;
import android.widget.EditText;

public class Result {

     String year;
     String semester;
     String mark;
     String subject;
     String gpa;

    public Result() {
    }

    public Result(String year, String semester, String mark, String subject, String gpa) {
        this.year = year;
        this.semester = semester;
        this.mark = mark;
        this.subject = subject;
        this.gpa = gpa;
    }




    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getMarks() {
        return mark;
    }

    public void setMarks(String marks) {
        this.mark = marks;
    }

    public String getSubjects() {
        return subject;
    }

    public void setSubjects(String subjects) {
        this.subject = subjects;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
}
