package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LeadsTable extends Table {

	public LeadsTable(WebDriver driver, ActionBot bot, By selector) {
		super(driver, bot, selector);
	}
}
