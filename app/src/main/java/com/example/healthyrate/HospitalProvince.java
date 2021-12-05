package com.example.healthyrate;

import android.content.Intent;

public class HospitalProvince {
    private String hID;
    private String province;
    private String hName;
    private String city;
    private String address;
    private String desc;
    private Integer conNo;

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public HospitalProvince() {
    }

    public String gethID() {
        return hID;
    }

    public void sethID(String hID) {
        this.hID = hID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getConNo() {
        return conNo;
    }

    public void setConNo(Integer conNo) {
        this.conNo = conNo;
    }

}
