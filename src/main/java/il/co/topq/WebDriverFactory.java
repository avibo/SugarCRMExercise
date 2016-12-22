package il.co.topq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	private static WebDriver driver = null;
	private static final String MAIN_SCREEN_URL = "https://www.softaculous.com/demos/SugarCRM";

	public static WebDriver getNewDriver(){
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(MAIN_SCREEN_URL);
		driver.manage().window().maximize();
		driver.switchTo().frame("demobody");
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
}
