package com.campusnex.studentlist;

public class PersonalProfile {
    private String enrollmentNo;
    private String name;
    private String gender;
    private String contactNo;
    private String email;
    // Add other attributes as needed
    
    // Constructor
    public PersonalProfile(String enrollmentNo, String name, String gender, String contactNo, String email) {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.gender = gender;
        this.contactNo = contactNo;
        this.email = email;
    }
    
    // Getters and setters
    public String getEnrollmentNo() {
        return enrollmentNo;
    }
    
    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getContactNo() {
        return contactNo;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    // Add getters and setters for other attributes
}
