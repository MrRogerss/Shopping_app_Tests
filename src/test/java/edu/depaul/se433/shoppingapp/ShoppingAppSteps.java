package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ShoppingAppSteps {

  private double initialcost = 0;
  private String state = "";
  private ShippingType shippingType;
  private double expected = 0;

  private TotalCostCalculator calculator = new TotalCostCalculator();

  @Given("Customer has items that total {double}")
  public void customer_has_items_that_total(double double1) {
    initialcost = double1;
  }

  @Given("Customer lives in {string}")
  public void customer_lives_in(String string1){
    state = string1;
  }

  @Given("Customer selects {string} shipping")
  public void customer_selects_shipping(String shippingType1){
    if(shippingType1.equals("Standard"))
    {
      shippingType = ShippingType.STANDARD;
    }
    if(shippingType1.equals("Next Day"))
    {
      shippingType = ShippingType.NEXT_DAY;
    }
  }

  @Then("the final price is {double}")
  public void the_final_price_is(double double1){
    expected = double1;
    double actual = calculator.calculate(initialcost,state,shippingType);
    assertEquals(expected,actual);
  }








}
