package com.example.myappfour;

public class StudentsClass {

     String name;
     String marks;

    public StudentsClass(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public StudentsClass(String name, String marks) {
        this.name = name;
        this.marks = marks;
    }
}
