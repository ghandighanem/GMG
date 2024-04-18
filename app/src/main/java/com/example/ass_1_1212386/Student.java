package com.example.ass_1_1212386;

import java.io.Serializable;

public class Student implements Serializable {
    public Student(String name, String subject, int mark, int attendance, String behavior) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
        this.attendance = attendance;
        this.behavior = behavior;
    }

    private String name;
    private String subject;
    private int mark;
    private int attendance;
    private String behavior;

    public Student() {

    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    // Constructor, getters, setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
