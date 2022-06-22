package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class shopppingCartTests {
  private TotalCostCalculator totalCostCalculator;


  @BeforeEach
  void setup()
  {
    totalCostCalculator = new TotalCostCalculator();

  }

  @Test
  @DisplayName("ShoppingCart and BillTotal return the expected value")
  void shoppingCartTest1(){
    PurchaseItem purchaseItem = new PurchaseItem("Spatula",10.00,2);
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addItem(purchaseItem);
    Bill newBill = totalCostCalculator.calculate(shoppingCart,"GA",ShippingType.STANDARD);
    assertEquals(30,newBill.total());
  }

  @Test
  @DisplayName("Get items returns correct amount of items in the cart")
  void shoppingCartTest2(){
    PurchaseItem p1 = new PurchaseItem("Spatula",10.00,2);
    PurchaseItem p2 = new PurchaseItem("Movie",20.00,1);
    PurchaseItem p3 = new PurchaseItem("PS5",600.00,1);
    PurchaseItem p4 = new PurchaseItem("Rice",3.00,3);
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.addItem(p1);
    shoppingCart.addItem(p2);
    shoppingCart.addItem(p3);
    shoppingCart.addItem(p4);
    assertEquals(4,shoppingCart.itemCount());
  }

  @Test
  @DisplayName("Adding an item with a quantity of 0 should return an error")
  void shoppingCartTest3(){
    PurchaseItem purchaseItem = new PurchaseItem("Spatula",10.00,0);
    ShoppingCart shoppingCart = new ShoppingCart();
    assertThrows(Exception.class, () -> shoppingCart.addItem(purchaseItem));
  }

  @Test
  @DisplayName("Adding an item with a negative quantity should return an error")
  void shoppingCartTest4(){
    PurchaseItem purchaseItem = new PurchaseItem("Spatula",10.00,-1);
    ShoppingCart shoppingCart = new ShoppingCart();
    assertThrows(Exception.class, () -> shoppingCart.addItem(purchaseItem));
  }





}
