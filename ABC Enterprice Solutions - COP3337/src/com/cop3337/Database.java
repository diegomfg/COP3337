package com.cop3337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.cop3337.*;

public class Database {
  private List<Product> products;
  private List<Product> deletedProducts;

  public Database() {
    this.products = new ArrayList<>(Arrays.asList(
        new Product(
            new Manufacturer("Echo", new Address("CA")),
            "Chainsaw", 5, 199.99)));
    
    this.deletedProducts = new ArrayList<>();
  }

  public List<Product> findAllProducts(){
    return this.products;
  }

  public List<Product> findInactiveProducts(){
    return this.deletedProducts;
  }

  public boolean insertProduct(Product product){
    product.setId(this.products.size()+1);
    return this.products.add(product);
  }

  public Product findProduct(int index){
    return this.products.get(index - 1);
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
}
