package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class LeadsPage extends SugarCrmMainPage{

	private By createLeadsBtn = By.xpath("//img[@alt=\"Create Lead\"]");
	private By viewLeadsBtn = By.xpath("//img[@alt=\"View Leads\"]");
	
	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void waitForScreenToLoad() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt=\"Create Lead\"]")));
	}
	
	public CreateLeadPage navToCreateLeadPage(){
		report.log("About to click create new lead button button");
		bot.clickOnElementBy(createLeadsBtn);		
		return new CreateLeadPage(driver);
	}
	
	public SearchLeadsPage navToSearchLeadsPage(){
		report.log("About to click search leads button");
		bot.clickOnElementBy(viewLeadsBtn);
		return new SearchLeadsPage(driver);
	}
}
