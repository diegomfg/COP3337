package com.cop3337;

import java.util.ArrayList;
import java.util.List;

public class Database {
  private List<Product> products;
  private List<Manufacturer> manufacturers;
  private List<Product> deletedProducts;

  public Database() {
    this.products = new ArrayList<>();
    this.manufacturers = new ArrayList<>();
  }

  public List<Product> findAllProducts(){
    return this.products;
  }

  public boolean insertProduct(Product product){
    return this.products.add(product);
  }

  public Product findProduct(int index){
    return this.products.get(index);
  }

  public boolean deleteProduct(int index){
    return this.deletedProducts.add(this.products.remove(index));
  }

  public Product editProduct(int index, String name, int quantities, double newPrice){
    return this.products
                .get(index)
                .setName(name)
                .setQuantity(quantities)
                .setUnitPrice(newPrice);
  }

  public List<Manufacturer> findAllManufacturers(){
    return this.manufacturers;
  }

  public boolean insertManufacturer(Manufacturer manufacturer){
    return this.manufacturers.add(manufacturer);
  }
}
