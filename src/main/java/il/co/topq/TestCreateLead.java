package il.co.topq;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateLead extends BasicTestCase {

	@Test()
	public void testCreateLead() throws InterruptedException {
		String firstName = "Avi";
		String lastname = "Bo";
		String officePhone = "088473570";
		report.startLevel("Performing login");

		loginScreen.setUserName("admin");
		loginScreen.setPassward("pass");
		SugarCrmMainPage mainPage = loginScreen.clickOnLoginBtnAndGoToWelcomePage();
		SearchLeadsPage searchLeadsPage = mainPage.mainMenu.selectSalesMenu().navToLeadsPage();
		CreateLeadPage createLeadPage = searchLeadsPage.navToCreateLeadPage();
		report.endLevel();
		report.startLevel("Creating new lead");
		createLeadPage.setFirstName(firstName);
		createLeadPage.setLastName(lastname);
		createLeadPage.setOfficePhoneTB(officePhone);
		createLeadPage.saveLead();
		report.endLevel();
		report.startLevel("Searching our new lead in the leads table");
		searchLeadsPage = createLeadPage.navToSearchLeadsPage();
		searchLeadsPage.setLeadsSearchTB("Avi");
		searchLeadsPage.clickLeadsSearchBtn();
		Assert.assertEquals(searchLeadsPage.table.getTableRow(firstName + " " + lastname) != null, true, "The following values weren't in the table: " + firstName + " " + lastname);
		report.endLevel();

	}

}
