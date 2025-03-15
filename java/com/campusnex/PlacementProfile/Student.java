package com.campusnex.PlacementProfile;
public class Student {
    private String enrollmentNo;
    private String domain;
    private String resume;
    private double cgpa;
    private boolean internship;
    private boolean certification;

    public Student(String enrollmentNo, String domain, String resume, double cgpa, boolean internship, boolean certification) {
        this.enrollmentNo = enrollmentNo;
        this.domain = domain;
        this.resume = resume;
        this.cgpa = cgpa;
        this.internship = internship;
        this.certification = certification;
    }

    // Getters and Setters
    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public boolean hasInternship() {
        return internship;
    }

    public void setInternship(boolean internship) {
        this.internship = internship;
    }

    public boolean hasCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
}
