package il.co.topq;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObjectBase {

	private By userNameTb = By.id("user_name");
	private By passwardTb = By.id("user_password");
	private By loginBtn = By.id("login_button");
	
	//User info pop upss' elements
	private By nextBtn = By.id("next_tab_personalinfo");
	private By emailTB = By.id("email1");
	private By secondNextBtn = By.id("next_tab_locale");
	private By finalNextBtn = By.id("next_tab_finish");
	private By finishBtn = By.xpath("//input[@type = \"submit\"]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void waitForScreenToLoad() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name")));
	}
	
	private SugarCrmMainPage handleUseInfoPage(){
		bot.clickOnElementBy(nextBtn);
		bot.sendKeyToElementBy(emailTB, "avi12345@gmail.com");
		bot.clickOnElementBy(secondNextBtn);
		bot.clickOnElementBy(finalNextBtn);
		bot.clickOnElementBy(finishBtn);
		
		return new SugarCrmMainPage(driver);
	}

	public SugarCrmMainPage clickOnLoginBtnAndGoToWelcomePage() {
		report.log("About to click login button");
		bot.clickOnElementBy(loginBtn);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));	
			return handleUseInfoPage();
		}catch(TimeoutException e){
			return new SugarCrmMainPage(driver);
		}
	}
	
	public void setUserName(String userName) {
		report.log("About to type '" + userName+"' to user name tb");
		bot.sendKeyToElementBy(userNameTb, userName);
	}
	
	public void setPassward(String password) {
		report.log("About to type '" + password+"' to password tb");
		bot.sendKeyToElementBy(passwardTb, password);
	}
}
