package com.example.study1.member;

public class Member {

    private Long id;
    private String phoneNumber;
    private Grade grade;

    public Member(Long id, String phoneNumber, Grade grade) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
