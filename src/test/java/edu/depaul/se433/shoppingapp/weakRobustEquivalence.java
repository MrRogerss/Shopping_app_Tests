package edu.depaul.se433.shoppingapp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;



public class weakRobustEquivalence {

  private TotalCostCalculator totalCostCalculator;

  @BeforeEach
  void setup()
  {
    totalCostCalculator = new TotalCostCalculator();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/weakNormal.csv", numLinesToSkip = 1)
  @DisplayName("Weak Robust Valid Input")
  public void weakRobustValid(double initialCost, String state, ShippingType shippingType, double expected){

    double result = totalCostCalculator.calculate(initialCost,state,shippingType);
    assertEquals(expected,result,1e-2);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/weakRobust.csv", numLinesToSkip = 3)
  @DisplayName("Weak Robust Invalid Input")
  public void weakRobustInvalid(double initialCost, String state, ShippingType shippingType){
    assertThrows(Exception.class, () -> totalCostCalculator.calculate(initialCost,state,shippingType));
  }

}
