package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class mocksPurchaseAgent {

@Test
@DisplayName("getPurchase in purchaseAgent returns the expected List")
public void correctPurchase()
{
  Purchase p1 = new Purchase();
  Purchase p2 = new Purchase();
  p1.make("Joe",LocalDate.now(),50,"IL","STANDARD");
  p2.make("Joe",LocalDate.now(),750,"IL","STANDARD");
  List<Purchase> purchaseListMock = new ArrayList<Purchase>();
  purchaseListMock.add(p1);
  purchaseListMock.add(p2);
  PurchaseDBO mockDBO = mock(PurchaseDBO.class);
  PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
  when(mockDBO.getPurchases("Joe")).thenReturn(purchaseListMock);
  List<Purchase> results = purchaseAgent.getPurchases("Joe");
  assertEquals(purchaseListMock,results);
}

@Test
@DisplayName("getPurchase does not throw an exception on an error")
public void noExceptionOnError(){
  PurchaseDBO mockDBO = mock(PurchaseDBO.class);
  PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
  when(mockDBO.getPurchases(null)).thenThrow();
  assertDoesNotThrow(() ->purchaseAgent.getPurchases(null));
}

@Test
@DisplayName("getPurchase returns an empty list on an error")
public void emptyListOnError(){
  List<Purchase> purchaseListMock = new ArrayList<Purchase>();
  PurchaseDBO mockDBO = mock(PurchaseDBO.class);
  PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
  when(mockDBO.getPurchases(anyString())).thenThrow();
  List<Purchase> results = purchaseAgent.getPurchases("h");
  assertEquals(purchaseListMock,results);
}

@Test
@DisplayName("getAverage returns the correct average purchase")
public void correctAverage(){
  Purchase p1 = new Purchase();
  Purchase p2 = new Purchase();
  Purchase p3 = new Purchase();
  p1.make("Joe",LocalDate.now(),243,"IL","STANDARD");
  p2.make("Joe",LocalDate.now(),750,"IL","STANDARD");
  p3.make("Joe",LocalDate.now(),116,"IL","STANDARD");
  List<Purchase> purchaseListMock = new ArrayList<Purchase>();
  purchaseListMock.add(p1);
  purchaseListMock.add(p2);
  purchaseListMock.add(p3);
  PurchaseDBO mockDBO = mock(PurchaseDBO.class);
  PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
  when(mockDBO.getPurchases("Joe")).thenReturn(purchaseListMock);
  double average = (p1.getCost() + p2.getCost() + p3.getCost())/purchaseListMock.size();
  double results = purchaseAgent.averagePurchase("Joe");
  assertEquals(average,results);
}

@Test
@DisplayName("average on an empty list should return 0")
public void averageEmptyList(){
  List<Purchase> purchaseListMock = new ArrayList<Purchase>();
  PurchaseDBO mockDBO = mock(PurchaseDBO.class);
  PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
  when(mockDBO.getPurchases(anyString())).thenReturn(purchaseListMock);
  double results = purchaseAgent.averagePurchase("ok");
  assertEquals(0.0,results);
}

@Test
@DisplayName("verify if purchaseAgent makes correct call to DBO in save()")
public void verifySave(){
  Purchase p1 = new Purchase();
  p1.make("Moe",LocalDate.now(),243,"IL","STANDARD");

  PurchaseDBO mockDBO = mock(PurchaseDBO.class);
  PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
  purchaseAgent.save(p1);
  verify(mockDBO,times(1)).savePurchase(p1);

}

  @Test
  @DisplayName("verify purchaseAgent does not save on null purchase")
  public void verifySaveOnNullPurchase(){

    PurchaseDBO mockDBO = mock(PurchaseDBO.class);
    PurchaseAgent purchaseAgent = new PurchaseAgent((mockDBO));
    purchaseAgent.save(null);
    verify(mockDBO,times(0)).savePurchase(null);

  }





}
