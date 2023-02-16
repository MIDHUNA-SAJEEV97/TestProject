package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	WebDriver driver;

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement title7rmartSuperMarket;
	
	@FindBy(xpath = "//a[ @data-toggle='dropdown']")
	WebElement adminNameAfterLogin ;

	
	public LoginPageClass(WebDriver driver) {     //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	public void enterUserName(String usrName) {
		userName.sendKeys(usrName);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickOnSignIn() {
		signInButton.click();
	}
	public boolean is7rmartSupermarketDisplayed() {
		return title7rmartSuperMarket.isDisplayed();
	}
	public String getTextOF7rmartSupermarket() {
		return title7rmartSuperMarket.getText();
	}
	public boolean adminNameAfterLoginisDisplayed() {
		return adminNameAfterLogin.isDisplayed();
	}
}
