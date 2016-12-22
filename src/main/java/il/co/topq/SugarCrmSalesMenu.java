package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SugarCrmSalesMenu extends SugarCrmMainMenu {
	
	private By leadsBtn = By.id("moduleTab_0_Leads");
	
	public SugarCrmSalesMenu(WebDriver driver){
		super(driver);
	}
	
	public SearchLeadsPage navToLeadsPage(){
		report.log("About to click leads button");
		bot.clickOnElementBy(leadsBtn);	
		return new SearchLeadsPage(driver);
	}
}
