package com.cop3337;

public class Dealer {
    private Customer customer;
    private Vehicle vehicle;

    public Dealer(Customer customer) {
        this.customer = customer;
    }

    public Dealer(Vehicle vehicle, Customer customer) {
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public String getCustomer() {
        System.out.println(customer.getName());
        return customer.getName();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
