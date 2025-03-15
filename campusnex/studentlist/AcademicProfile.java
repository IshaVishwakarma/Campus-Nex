package com.campusnex.studentlist;

public class AcademicProfile {
    private String enrollmentNo;
    private String major;
    private String yearOfStudy;
    // Add other attributes as needed
    
    // Constructor
    public AcademicProfile(String enrollmentNo, String major, String yearOfStudy) {
        this.enrollmentNo = enrollmentNo;
        this.major = major;
        this.yearOfStudy = yearOfStudy;
    }
    
    // Getters and setters
    public String getEnrollmentNo() {
        return enrollmentNo;
    }
    
    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }
    
    public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public String getYearOfStudy() {
        return yearOfStudy;
    }
    
    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    // Add getters and setters for other attributes
}
