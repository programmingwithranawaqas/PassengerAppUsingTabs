package com.example.passengerapp;

public class Passenger {
    String name;
    String preference; // bus/plane
    String cnic, mobile;

    public Passenger() {
    }

    public Passenger(String name, String preference, String cnic, String mobile) {
        this.name = name;
        this.preference = preference;
        this.cnic = cnic;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", preference='" + preference + '\'' +
                ", cnic='" + cnic + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
