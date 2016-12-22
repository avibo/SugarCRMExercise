package il.co.topq;

import org.openqa.selenium.WebDriver;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public abstract class MenuBar {
	
	protected static ReportDispatcher report = ReportManager.getInstance();
	protected final WebDriver driver;
	protected final ActionBot bot;
	
	public MenuBar(WebDriver driver){
		this.driver = driver;
		final String pageName = this.getClass().getSimpleName();
		bot = new ActionBot(driver, pageName);
	}
}
