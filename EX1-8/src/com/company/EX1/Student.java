package com.company.EX1;

public class Student{
    private String name;
    private Integer totalScore;

    public Student(String name, Integer totalScore) {
        this.name = name;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "(" +
                name + " " + totalScore +
                ')';
    }
}
