package com.java.gst;

public class Calculator {

  public static Double Total (Double rate, Integer quantity) {
    return rate * quantity;
  }

  public static Double Discounted_Total (Double total, Double discount) {
    return (total-(total*discount));
  }

  public static Double GST_Total (Double discounted_total, Double gst) {
    return (discounted_total+(discounted_total*gst));
  }

}
