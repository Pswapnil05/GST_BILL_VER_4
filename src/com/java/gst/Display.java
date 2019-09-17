package com.java.gst;


public class Display {
  private static Double Food_Total = 0.0;
  private static Double Furn_Total = 0.0;
  private static Double Elect_Total = 0.0;
  private static Double Discounted_Furn_Total;
  private static Double Discounted_Food_Total;
  private static Double Discounted_Elect_Total;
  private static Double Gst_Furn_Total;
  private static Double Gst_Food_Total;
  private static Double Gst_Elect_Total;
  private static Double Final_Bill;

  public static void main(String[] args) {

    for (Product s : Product.cart) {
      if (s.getCategory() == Product.Category.FOOD)
        Food_Total += Calculator.Total(s.getRate(), Inventory.quantity.get(s.getName()));
      else if (s.getCategory() == Product.Category.FURNITURE)
        Furn_Total += Calculator.Total(s.getRate(), Inventory.quantity.get(s.getName()));
      else
        Elect_Total += Calculator.Total(s.getRate(), Inventory.quantity.get(s.getName()));
    }
    System.out.println("Food Total = Rs: "+Food_Total);
    System.out.println("Furniture Total = Rs: "+Furn_Total);
    System.out.println("Electronics Total = Rs: "+Elect_Total);

    if (Furn_Total>50000) {
      Discounted_Furn_Total = Calculator.Discounted_Total(Furn_Total, Product.Offer.FURNITURE.getDiscount());
      System.out.println("Furniture Amount After 5% discount = Rs: " + Discounted_Furn_Total);
      Gst_Furn_Total = Calculator.GST_Total(Discounted_Furn_Total, Product.Category.FURNITURE.getGst());
    }
    if (Food_Total>2000)
      Discounted_Food_Total = Calculator.Discounted_Total(Food_Total, Product.Offer.FOOD.getDiscount());
    else {
      Gst_Food_Total = Calculator.GST_Total(Food_Total, Product.Category.FOOD.getGst());

    }
    if (Elect_Total>100000)
      Discounted_Elect_Total = Calculator.Discounted_Total(Elect_Total, Product.Offer.ELECTRONICS.getDiscount());
      System.out.println("Electronics Amount After 10% discount = Rs: "+ Discounted_Elect_Total);
      Gst_Elect_Total = Calculator.GST_Total(Discounted_Elect_Total,Product.Category.ELECTRONICS.getGst());

    System.out.println("Food Amount with 5% GST = Rs: "+Gst_Food_Total);
    System.out.println("Furniture Amount with 10% GST = Rs: "+Gst_Furn_Total);
    System.out.println("Electronics Amount with 15% GST = Rs: "+Gst_Elect_Total);
    Final_Bill= (Gst_Food_Total+Gst_Furn_Total+Gst_Elect_Total);
    System.out.println("Final Bill = Rs: "+Final_Bill);



  }
}
