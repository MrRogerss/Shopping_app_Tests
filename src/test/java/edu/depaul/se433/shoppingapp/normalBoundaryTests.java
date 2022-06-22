package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;


public class normalBoundaryTests {


@ParameterizedTest
@CsvFileSource(resources = "/normalBoundaryTestCalculateTotal.csv", numLinesToSkip = 0)
@DisplayName("Normal Boundary Tests")
  void totalCostBoundaryTest(double initialCost,String state, ShippingType shippingType, double expected)
{
  TotalCostCalculator totalCostCalculator = new TotalCostCalculator();
  double result = totalCostCalculator.calculate(initialCost,state,shippingType);
  assertEquals(expected,result,1e-2);

}





}
