package com.campusnex.studentlist;

public class PlacementProfile {
    private String enrollmentNo;
    private String domain;
    private double cgpa;

    public PlacementProfile(String enrollmentNo, String domain, double cgpa) {
        this.enrollmentNo = enrollmentNo;
        this.domain = domain;
        this.cgpa = cgpa;
    }

   

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

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
