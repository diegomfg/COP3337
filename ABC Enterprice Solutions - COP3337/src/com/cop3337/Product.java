package com.cop3337;

import java.text.DateFormat;
import java.util.Date;
import com.cop3337.*;
public class Product {
    private int id;
    private Manufacturer manufacturer;
    private String name;
    private int quantity;
    private double unitPrice;
    private String purchaseDate;

    public Product(Manufacturer manufacturer, String name, int quantity, double unitPrice) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.purchaseDate = DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String _name) {
        name = _name;
        return this;
    }

    public int getId() {
        return id;
      }
  
      public Product setId(int id) {
        this.id = id;
        return this;
      }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
      }

    public Product setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    @Override
    public String toString() {
        return  "Manufacturer Name: " + manufacturer.getName() +
                "\nManufacturer Address: " + manufacturer.getAddress() +
                "\nName='" + name + '\'' +
                "\nQuantity=" + quantity +
                "\nUnit Price=" + unitPrice;
    }

}
