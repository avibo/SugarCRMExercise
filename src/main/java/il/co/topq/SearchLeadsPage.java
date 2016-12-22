package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchLeadsPage extends LeadsPage{
	
	private By leadsSearchTB = By.id("search_name_basic");
	private By leadsSearchBtn = By.id("search_form_submit");
	private By leadsTable = By.xpath("//form[@id = 'MassUpdate']/table/tbody");
	public LeadsTable table;
	
	public SearchLeadsPage(WebDriver driver) {
		super(driver);
		table = new LeadsTable(driver, bot, leadsTable);
	}
	
	@Override
	public void waitForScreenToLoad() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_name_basic")));
	}
	
	public void setLeadsSearchTB(String name){
		report.log("About set the value " + name + " in the search box");
		bot.sendKeyToElementBy(leadsSearchTB, name);
	}

	public void clickLeadsSearchBtn(){
		report.log("About to click search button");
		bot.clickOnElementBy(leadsSearchBtn);
	}
}
