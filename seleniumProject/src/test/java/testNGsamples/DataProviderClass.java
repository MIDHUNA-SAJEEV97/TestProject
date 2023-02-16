package testNGsamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  @Test(dataProvider = "dp1")
  public void add(Integer n, Integer m) {
	  System.out.println(n+m);
  }
  @Test(dataProvider = "dp2")
  public void subtraction(Integer n, Integer a) {
	  System.out.println( n-a);
  }
  @Test(dataProvider = "dp1")
  public void multiplication(Integer f, Integer g) {
	  System.out.println(f*g);
  }
  @DataProvider(name="dp1")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 8, 5 },
      new Object[] { 9, 4}
    };
  }
  
  @DataProvider(name="dp2")
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { 5, 2 }
     
    };
  }
}
