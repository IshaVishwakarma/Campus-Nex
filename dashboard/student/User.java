package com.dashboard.student;

public class User {
    private String name;
    private String enrollmentNo;
    private String email;
    
    // Constructor, getters, and setters
    public User() {
    	
    }
    
    public User(String name, String enrollmentNo, String email) {
        this.name = name;
        this.enrollmentNo = enrollmentNo;
        this.email = email;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEnrollmentNo() {
        return enrollmentNo;
    }
    
    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

