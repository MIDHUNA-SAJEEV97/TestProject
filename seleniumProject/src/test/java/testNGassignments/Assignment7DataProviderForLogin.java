package testNGassignments;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Assignment7DataProviderForLogin {

  @DataProvider(name="successfullLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {  "carol","1q2w3e4r" },
      
    };
  }
  
  @DataProvider(name="UnSuccessfullLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] {  "carol","123456" },
      new Object[] {  "midhuna","1q2w3e4r" },
      new Object[] {  "admin","admin12" }
    };
  }
}
