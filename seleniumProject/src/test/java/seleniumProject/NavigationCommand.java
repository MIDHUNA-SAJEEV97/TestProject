package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommand {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
	 	driver.navigate().to("http://groceryapp.uniqassosiates.com/admin/login");
		driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
	}

}
