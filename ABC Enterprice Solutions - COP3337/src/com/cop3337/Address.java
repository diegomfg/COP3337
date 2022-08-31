package com.cop3337;

public class Address {
  public String address;

  public Address(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return this.address;
  }

  
}
