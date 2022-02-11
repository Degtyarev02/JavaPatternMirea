package com.company.EX1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Comparator<Student> studentComparator = (s1, s2) -> -(s1.getTotalScore().compareTo(s2.getTotalScore()));
        Student stu1 = new Student("Mike", 95);
        Student stu2 = new Student("Nick", 32);
        Student stu3 = new Student("Nack", 83);
        Student stu4 = new Student("Jhon", 53);
        Student stu5 = new Student("James", 65);
        Student stu6 = new Student("Nick", 99);
        List<Student> students = Arrays.asList(stu1, stu2, stu3, stu4, stu5, stu6);
        students.sort(studentComparator);
        System.out.println(students);
    }
}
