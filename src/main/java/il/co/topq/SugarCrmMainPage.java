package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SugarCrmMainPage extends PageObjectBase {

	public final SugarCrmMainMenu mainMenu;
	
	public SugarCrmMainPage(WebDriver driver) {
		super(driver);
		mainMenu = new SugarCrmMainMenu(driver);
	}

	@Override
	public void waitForScreenToLoad() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_0")));
	}

}
