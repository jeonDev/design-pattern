package org.dp.builder.pattern;

public class Main {

    public static void main(String[] args) {
        Student student = new StudentBuilder()
                .id(1234)
                .name("abc")
                .grade("Senior")
                .phoneNumber("010-1111-2222")
                .build();
        Student student1 = new Student2Builder(1234)    // 필수값
                .name("a")
                .build();
        System.out.println(student);
        System.out.println(student1);
    }
}
