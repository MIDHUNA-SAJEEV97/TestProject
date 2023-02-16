package testNGsamples;

import org.testng.annotations.Test;

public class DataProviderTestClass {
  @Test(dataProvider="dp1",dataProviderClass=DataProviderClass.class)
  public void addition(Integer a, Integer b) {
	  System.out.println(a+b);
  }
  
  @Test(dataProvider="dp1",dataProviderClass=DataProviderClass.class)
  public void sub(Integer a, Integer b) {
	  System.out.println(a-b);
  }
  
  @Test(dataProvider="dp2",dataProviderClass=DataProviderClass.class)
  public void mult(Integer a, Integer b) {
	  System.out.println(a*b);
  }
}
