package org.dp.builder.pattern;

public class Student2Builder {
    private int id;
    private String name;
    private String grade;
    private String phoneNumber;

    public Student2Builder(int id) {
        this.id = id;
    }

    public Student2Builder id(int id) {
        this.id = id;
        return this;
    }

    public Student2Builder name(String name) {
        this.name = name;
        return this;
    }

    public Student2Builder grade(String grade) {
        this.grade = grade;
        return this;
    }

    public Student2Builder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Student build() {
        return new Student(id, name, grade, phoneNumber);
    }

}
