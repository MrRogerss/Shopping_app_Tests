package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class strongRobustEquivalence {
  private TotalCostCalculator totalCostCalculator;


  @BeforeEach
  void setup()
  {
    totalCostCalculator = new TotalCostCalculator();

  }

  @ParameterizedTest
  @CsvFileSource(resources = "/strongNormal.csv",numLinesToSkip = 1)
  @DisplayName("Strong Normal Tests")
  public void strongRobustValid(double initialCost,String state, ShippingType shippingType, double expected){
    double result = totalCostCalculator.calculate(initialCost,state,shippingType);
    assertEquals(expected,result,1e-2);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/strongRobust.csv", numLinesToSkip = 5)
  @DisplayName("Strong Robust Invalid Input")
  public void strongRobustInvalid(double initialCost, String state, ShippingType shippingType){
    assertThrows(Exception.class, () -> totalCostCalculator.calculate(initialCost,state,shippingType));
  }

}
