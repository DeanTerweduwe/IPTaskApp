package com.example.demo.overschot;


public class Resto {
    private String  name;
    private String address;
    private String rateing;


    public Resto(String name, String address, String rateing) {
        this.name = name;
        this.address = address;
        this.rateing = rateing;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRateing() {
        return rateing;
    }

    public void setRateing(String rateing) {
        this.rateing = rateing;
    }

}
