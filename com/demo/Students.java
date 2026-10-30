package com.demo;


public class Students {
    private int rollNo;
    private String name;
    private String course;


    public Students(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }


    public int getRollNo()    { return rollNo; }
    public String getName()   { return name; }
    public String getCourse() { return course; }
}