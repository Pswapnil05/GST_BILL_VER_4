package com.java.gst;

import java.util.ArrayList;
import java.util.List;

public class Product {

  static List<Product> cart = new ArrayList<Product>();
  private String name;
  private Double rate;
  private Category category;

  public Product(String name, Double rate, Integer category) {
    this.name = name;
    this.rate = rate;
//    if (category>2) category=category%3;
    this.category = Category.values()[category];
  }

  public Category getCategory() { return category; }
  public String getName() { return name; }
  public Double getRate() { return rate; }

  enum Category { FOOD(0.05), FURNITURE(0.1), ELECTRONICS(0.15);
    private Double gst;
    Category(Double gst) { this.gst = gst; }
    public Double getGst() { return gst; }
  }

  enum Offer {
    FOOD(0.01), FURNITURE(0.05), ELECTRONICS(0.1);
    private Double discount;
    Offer(Double discount) { this.discount = discount; }
    public Double getDiscount() { return discount; }
  }

  @Override
  public String toString() {
    return "Product [name = " + name +
        ", rate = " + rate +
        ", category = " + category +
        ", gst_Slab = " + category.getGst() +
        ']';
  }

  static  {
    cart.add(new Product("Burger",25.0,0));
    cart.add(new Product("Chair", 900.0,1));
    cart.add(new Product("Laptop", 49000.0,2));
    cart.add(new Product("Oreo", 90.0,0));
    cart.add(new Product("Sofa", 19000.0,1));
    cart.add(new Product("TV", 69000.0,2));
  }

}
