package com.learn.designpattern.creational.builder.p1;

public final class Student {

    private String name;
    private int age;
    private int gradYear;

    private Student() {
    }

    private Student(final StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.age = studentBuilder.age;
        this.gradYear = studentBuilder.gradYear;
    }

    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }

    public static final class StudentBuilder {

        private String name;
        private int age;
        private int gradYear;

        private StudentBuilder() {
        }

        public StudentBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(final int age) {
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
