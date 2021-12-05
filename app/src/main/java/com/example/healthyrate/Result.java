package com.example.healthyrate;

public class Result {

    String ptid,ptname,ptstatus;

    public Result() {
    }

    public Result(String ptid, String ptname, String ptstatus) {
        this.ptid = ptid;
        this.ptname = ptname;
        this.ptstatus = ptstatus;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }

    public String getPtstatus() {
        return ptstatus;
    }

    public void setPtstatus(String ptstatus) {
        this.ptstatus = ptstatus;
    }
}
