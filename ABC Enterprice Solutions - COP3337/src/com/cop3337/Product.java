package com.cop3337;

public class Product {
    private Manufacturer manufacturer;
    private String Name;
    private int quantity;
    private double unitPrice;

    public Product(Manufacturer manufacturer, String name, int quantity, double unitPrice) {
        this.manufacturer = manufacturer;
        Name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "manufacturer=" + manufacturer +
                ", Name='" + Name + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
