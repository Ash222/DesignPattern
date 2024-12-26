package com.learn.designpattern.creational.prototype.p1;

import com.learn.designpattern.creational.prototype.IPrototype;

public final class Student implements IPrototype<Student> {

    private String studentName;
    private int studentId;
    private int studentClass;

    public Student() {
    }

    public Student(String studentName, int studentId, int studentClass) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentClass = studentClass;
    }

    private Student(Student student) {
        this.studentName = student.studentName;
        this.studentId = student.studentId;
        this.studentClass = student.studentClass;
    }

    @Override
    public Student getClone() {
        return new Student(this);
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentName='").append(studentName).append('\'');
        sb.append(", studentId=").append(studentId);
        sb.append(", studentClass=").append(studentClass);
        sb.append('}');

        return sb.toString();
    }
}
