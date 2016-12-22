package il.co.topq;


import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

public abstract class PageObjectBase {

	protected static ReportDispatcher report = ReportManager.getInstance();
	protected static WebDriverWait wait;
	protected final WebDriver driver;
	protected final ActionBot bot;

	public PageObjectBase(WebDriver driver) {
		wait = new WebDriverWait(driver, 20);
		this.driver = driver;
		final String pageName = this.getClass().getSimpleName();
		bot = new ActionBot(driver, pageName);
		report.log("Navigating to page " + pageName);
		try {
			waitForScreenToLoad();
		} catch (Throwable t) {
			report.log("Failed to wait for page " + pageName, Status.error);
			throw t;
		} finally {
			addScreenshot(pageName);
		}
	}
	
	public void addScreenshot(String description) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		report.addImage(scrFile, description);
	}


	public abstract void waitForScreenToLoad();
}
