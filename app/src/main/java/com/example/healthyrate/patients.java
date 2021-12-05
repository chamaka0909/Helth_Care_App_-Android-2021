package com.example.healthyrate;

public class patients {

    String name;
    String age;
    String phone;
    String address;
    String date;
    String type;

    public patients(String name, String age, String phone, String address, String date, String type) {

        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
