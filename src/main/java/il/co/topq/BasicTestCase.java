package il.co.topq;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

@Listeners(il.co.topq.difido.ReportManagerHook.class)
public class BasicTestCase {

	protected LoginPage loginScreen;

	protected ReportDispatcher report = ReportManager.getInstance();
	
	@BeforeMethod
	public void setUp() {
		loginScreen = new LoginPage(WebDriverFactory.getNewDriver());
		SQLUtills.setDBConnection();
	}

	@AfterMethod
	public void tearDown() {
		WebDriverFactory.getDriver().quit();
		SQLUtills.closeDBConnection();
	}
}
