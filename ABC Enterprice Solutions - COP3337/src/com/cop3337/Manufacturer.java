package com.cop3337;

public class Manufacturer {

    private String Name;
    private Address address;

    public Manufacturer(String name, Address address) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
