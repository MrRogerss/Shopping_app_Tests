package edu.depaul.se433.shoppingapp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;



public class weakNormalEquivalence {
  private TotalCostCalculator totalCostCalculator;


  @BeforeEach
  void setup()
  {
    totalCostCalculator = new TotalCostCalculator();

  }

  @ParameterizedTest
  @CsvFileSource(resources = "/weakNormal.csv", numLinesToSkip = 1)
  @DisplayName("Weak Normal Equivalence Tests")
  public void weakNormal(double initialCost,String state, ShippingType shippingType, double expected)
  {
    double result = totalCostCalculator.calculate(initialCost,state,shippingType);
    assertEquals(expected,result,1e-2);
  }

}
