package il.co.topq;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

public class ActionBot {

	private final WebDriver driver;
	private final String pageName;
	private WebDriverWait wait;
	protected static ReportDispatcher report = ReportManager.getInstance();
	
	public ActionBot(WebDriver driver, String pageName) {
		this.driver = driver;
		this.pageName = pageName;
		wait = new WebDriverWait(driver, 20);
	}
	
	public void clickOnElementBy(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
		try{
			driver.findElement(by).click();
			report.log("Clicked the element");
		}catch(NoSuchElementException e){
			report.log("Failed to click element" , Status.error);
			//addScreenshot(pageName);
		}
	}

	public void sendKeyToElementBy(By by, String text) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		try{
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(text);
			report.log("The value " + text + " is set");
		}catch(NoSuchElementException e){
			report.log("The element doesn'e exist" , Status.error);
			//addScreenshot(pageName);
		}catch(StaleElementReferenceException e){
			report.log("Failed to set value, the element is no longer exist" , Status.error);	
			//addScreenshot(pageName);
		}
	}

}
