package com.campusnex.loginuser;

public class User {
    private String enrollmentNo;
    private String password;
    private String name;
    private String email;

    public User(String enrollmentNo, String password, String name, String email) {
        this.enrollmentNo = enrollmentNo;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
