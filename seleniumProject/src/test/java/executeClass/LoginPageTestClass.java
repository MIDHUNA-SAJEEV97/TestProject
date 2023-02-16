package executeClass;

import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestClass {
	WebDriver driver;
	LoginPageClass lp;
	
  @Test
  public void verifyTheLoginPAgeIsDisplayedWhileOpeningUrl() {
	  lp=new LoginPageClass(driver);
	  
	 // Boolean actual=lp.is7rmartSupermarketDisplayed();
	 // Assert.assertTrue(actual);
	  String actual=lp.getTextOF7rmartSupermarket();
	  String expected="7rmart supermarket";
	  Assert.assertEquals(actual, expected);
  }
  @Test
  public void verifySuccessFullLogin() {
	  lp=new LoginPageClass(driver);
	  
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickOnSignIn();
	  
	  Boolean actual=lp.adminNameAfterLoginisDisplayed();
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

