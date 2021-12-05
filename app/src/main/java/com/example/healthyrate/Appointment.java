package com.example.healthyrate;

public class Appointment {

    private String appoID;
    private String userID;
    private String hospitalName;
    private String doctorName;
    private String patientName;
    private String patientAge;
    private String patientAddress;
    private String patientConNo;
    private String bookingDate;

    public Appointment() {
    }

    public String getAppoID() {
        return appoID;
    }

    public void setAppoID(String appoID) {
        this.appoID = appoID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientConNo() {
        return patientConNo;
    }

    public void setPatientConNo(String patientConNo) {
        this.patientConNo = patientConNo;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
