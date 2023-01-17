package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://selenium.obsqurazone.com/select-input.php");
		driver.manage().window().maximize();
		
		WebElement selectColourDropDown=driver.findElement(By.xpath("//select[@id='single-input-field']"));
	    selectColourDropDown.click();
	    Select select=new Select(selectColourDropDown);
	    select.selectByIndex(2);
	    //select.selectByValue("Red");
	    //select.selectByVisibleText("Green");
	    
	    WebElement selectedColourMsg=driver.findElement(By.id("message-one"));
	    System.out.println(selectedColourMsg.getText());
	    driver.close();
	    
	    
}
}