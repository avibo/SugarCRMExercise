package il.co.topq;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateLeadPage extends LeadsPage {

	private By firstNameTB = By.id("first_name");
	private By lastNameTB = By.id("last_name");
	private By officePhoneTB = By.id("phone_work");
	private By saveLeadBtn = By.id("SAVE_HEADER");
	
	public CreateLeadPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void waitForScreenToLoad() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first_name")));
	}
	
	public void setFirstName(String name){
		report.log("About set the value " + name + " in the first name box");
		bot.sendKeyToElementBy(firstNameTB, name);
	}

	public void setLastName(String name){
		report.log("About set the value " + name + " in the last name box");
		bot.sendKeyToElementBy(lastNameTB, name);
	}
	
	public void setOfficePhoneTB(String phoneNumber){
		report.log("About set the value " + phoneNumber + " in the office box");
		bot.sendKeyToElementBy(officePhoneTB, phoneNumber);
	}
	
	public void saveLead(){
		report.log("About to click save lead button");
		bot.clickOnElementBy(saveLeadBtn);
	}
}
