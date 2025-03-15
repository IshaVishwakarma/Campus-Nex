package com.campusnex.PersonalInfo;
import java.util.Date;

public class Student {
    private String enrollmentNo;
    private String name;
    private String contactNo;
    private String gender;
    private Date dob;
    private String address;

    // Constructor
    public Student() {
    }

    public Student(String enrollmentNo, String name, String contactNo, String gender, Date dob, String address) {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.contactNo = contactNo;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    // Getters and Setters
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
