package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClassAssignemt8 {
	WebDriver driver;

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage ;

	@FindBy(name = "remember_me")
	WebElement rememberMeCheckBox;
	
	public LoginPageClassAssignemt8(WebDriver driver) {
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
	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}
	
	public boolean isRememberMeCheckBoxSelected() {
		return rememberMeCheckBox.isSelected();
	}

}
