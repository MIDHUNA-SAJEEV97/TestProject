package executeClass;

import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import elementRepository.LoginPageClassAssignemt8;
import io.github.bonigarcia.wdm.WebDriverManager;
import testNGsamples.DataProviderForLogin;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageExecuteClassAssignment8 {
	WebDriver driver;
	LoginPageClassAssignemt8 lp;
	
  @Test
  public void verifyRememberMeCheckBoxSelectedByDefault() {
	  lp=new LoginPageClassAssignemt8(driver);
	  
	  Boolean actual=lp.isRememberMeCheckBoxSelected();
	  Assert.assertFalse(actual);
	  
  }
  @Test(dataProvider="UnSuccessfullLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifyUnsuccessFullLogin(String uName,String pw) {
	  lp=new LoginPageClassAssignemt8(driver);
	  
	  lp.enterUserName(uName);
	  lp.enterPassword(pw);
	  lp.clickOnSignIn();
	  
	  Boolean actual=lp.isAlertMessageDisplayed();
	  Assert.assertTrue(actual);
  }
 
  @BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
