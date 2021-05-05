package com.codegym;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;

    private String name;

    private String address;

    private String classes;

    private double mark;

    public Student() {
    }

    public Student(String id, String name, String address, String classes, double mark) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classes = classes;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", classes='" + classes + '\'' +
                ", mark=" + mark +
                '}';
    }
}
