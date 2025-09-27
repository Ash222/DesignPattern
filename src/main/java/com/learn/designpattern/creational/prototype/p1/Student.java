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
	    return "Student{" + "studentName='" + studentName + '\'' +
			    ", studentId=" + studentId +
			    ", studentClass=" + studentClass +
			    '}';
    }
}
