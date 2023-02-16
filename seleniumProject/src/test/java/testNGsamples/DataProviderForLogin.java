package testNGsamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
  

  @DataProvider(name="successfullLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {  "admin","admin" },    
    };
  }
  
  @DataProvider(name="UnSuccessfullLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] {  "admin21","admin" },
      new Object[] {  "admin21","admin12" },
      new Object[] {  "admin","admin12" }
    };
  }
}
