package com.cop3337;

public class Manufacturer {

    private String Name;
    private String address;

    public Manufacturer(String name, String address) {
        this.address = address;
        Name = name;
    }

    public Manufacturer() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
