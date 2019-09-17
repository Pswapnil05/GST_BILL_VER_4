package com.java.gst;

import java.util.HashMap;

public class Inventory {
  static HashMap<String, Integer> quantity = new HashMap<String, Integer>();

  static {
    quantity.put("Burger", 4);
    quantity.put("Chair", 4);
    quantity.put("Laptop", 2);
    quantity.put("Oreo", 8);
    quantity.put("Sofa", 3);
    quantity.put("TV", 1);

  }


}
