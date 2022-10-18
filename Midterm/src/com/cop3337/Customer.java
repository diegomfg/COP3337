package com.cop3337;

public class Customer {
    public Long accountNumber;
    public Name name;

    public Customer(Long accountNumber, String first, String last) {
        this.accountNumber = accountNumber;
        this.name = new Name(first,last);
    }

    public String getName() {
        return name.getLastName();
    }
}
