package com.learn.designpattern.creational.builder.p1;

public class Student {

    private String name;
    private int age;
    private int gradYear;

    private Student() {
    }

    private Student(StudentBuilder studentBuilder) {

        this.name = studentBuilder.name;
        this.age = studentBuilder.age;
        this.gradYear = studentBuilder.gradYear;
    }

    public static StudentBuilder getBuilder() {

        return new StudentBuilder();
    }

    public static class StudentBuilder {

        private String name;
        private int age;
        private int gradYear;

        private StudentBuilder() {
        }

        public StudentBuilder setName(String name) {

            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {

            this.age = age;
            return this;
        }

        public StudentBuilder setGradYear(int gradYear) {

            this.gradYear = gradYear;
            return this;
        }

        public Student build() {

            return new Student(this);
        }
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gradYear=").append(gradYear);
        sb.append('}');

        return sb.toString();
    }
}
