package com.cop3337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
  private List<Product> products;
  private List<Manufacturer> manufacturers;
  private List<Product> deletedProducts;

  public Database() {
    this.products = new ArrayList<>(Arrays.asList(
        new Product(
            new Manufacturer("Echo", "CA"),
            "Chainsaw", 5, 199.99)));
  }

  public String findAllProducts(){
    System.out.println(this.products);
    
    StringBuilder sb = new StringBuilder();
    int index = 0;
    for(Product p : this.products){
      ++index;
      sb.append("---Product #" + index + "---\n" + "Manufacturer Name: ")
        .append(p.getManufacturer().getName())
        .append("\nManufacturer Address: ")
        .append(p.getManufacturer().getAddress())
        .append("\nProcuct Name: ")
        .append(p.getName())
        .append("\nAvailable Quantity: ")
        .append(p.getQuantity())
        .append("\nPrice per unit: ")
        .append(p.getUnitPrice())
        .append("\n");
    }

    return sb.toString();
  }

  public boolean insertProduct(Product product){
    product.setId(this.products.size()+1);
    return this.products.add(product);
  }

  public String findProduct(int index){
    return this.products.get(index - 1).toString();
  }

  public boolean deleteProduct(int index){
    return this.deletedProducts.add(this.products.remove(index - 1));
  }

  public String editProduct(int index, String name, int quantities, double newPrice){
    return this.products
                .get(index - 1)
                .setName(name)
                .setQuantity(quantities)
                .setUnitPrice(newPrice)
                .toString();
  }

  public boolean insertManufacturer(Manufacturer manufacturer){
    return this.manufacturers.add(manufacturer);
  }
}
