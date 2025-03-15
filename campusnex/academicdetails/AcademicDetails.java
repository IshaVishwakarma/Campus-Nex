package com.campusnex.academicdetails;

public class AcademicDetails {
    private String enrollmentNo;
    private String department;
    private int passingOutYear;
    private double currentCGPA;
    private String marksheetPath;

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPassingOutYear() {
        return passingOutYear;
    }

    public void setPassingOutYear(int passingOutYear) {
        this.passingOutYear = passingOutYear;
    }

    public double getCurrentCGPA() {
        return currentCGPA;
    }

    public void setCurrentCGPA(double currentCGPA) {
        this.currentCGPA = currentCGPA;
    }

    public String getMarksheetPath() {
        return marksheetPath;
    }

    public void setMarksheetPath(String marksheetPath) {
        this.marksheetPath = marksheetPath;
    }
}
