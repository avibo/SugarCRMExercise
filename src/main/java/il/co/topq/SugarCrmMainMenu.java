package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SugarCrmMainMenu extends MenuBar {

	private By salesMenuBtn = By.id("grouptab_0");
	
	public SugarCrmMainMenu(WebDriver driver){
		super(driver);
	}
	
	public SugarCrmSalesMenu selectSalesMenu(){
		report.log("About to click sales menu button button");
		bot.clickOnElementBy(salesMenuBtn);
		return new SugarCrmSalesMenu(driver);
	}
}
