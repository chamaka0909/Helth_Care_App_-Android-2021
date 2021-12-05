package com.example.healthyrate;

public class pData {

    String nic;
    String name;
    String gen;
    String date;
    String time;
    String age;
    String blood;
    String diseases;
    String connum;

public pData(){

}
    public pData(String nic, String name,String gen, String date,String time, String age, String blood, String diseases, String connum) {
        this.nic = nic;
        this.name = name;
        this.gen = gen;
        this.date = date;
        this.time = time;
        this.age = age;
        this.blood = blood;
        this.diseases = diseases;
        this.connum = connum;
    }

    public String getNic() {
        return nic;
    }

    public String getName() {
        return name;
    }

    public String getGen() {
        return gen;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getAge() {
        return age;
    }

    public String getBlood() {
        return blood;
    }

    public String getDiseases() {
        return diseases;
    }

    public String getConnum() {
        return connum;
    }









    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public void setConnum(String connum) {
        this.connum = connum;
    }
}
