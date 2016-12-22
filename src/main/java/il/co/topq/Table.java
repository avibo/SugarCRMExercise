package il.co.topq;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Table {

	private final By by;
	protected WebElement table;
	protected List<TableRow> tableRows;
	protected WebDriver driver;
	protected ActionBot bot;
	
	public Table(WebDriver driver, ActionBot bot, By by){
		this.bot = bot;
		this.driver = driver;
		this.by = by;
	}
	
	public void init(){
		table = driver.findElement(by);
		tableRows = new ArrayList<>();
		String tableRowXpathLocator = by.toString().replace("By.xpath: ", "") + "/tr";
		List<WebElement> rows = driver.findElements(By.xpath(tableRowXpathLocator));
		for(int rowsCounter = 0; rowsCounter < rows.size(); rowsCounter++){
			tableRows.add(new LeadsTableRow(driver, rowsCounter, tableRowXpathLocator));
		}
	}
	
	public TableRow getTableRow(String... params){
		init();
		List<String> rowEelementsText;
		boolean isRowContainsParams = true;
		for(TableRow row : tableRows){
			rowEelementsText = row.getRowText();
			if(!rowEelementsText.isEmpty()){
				for(String param : params){
					if(!rowEelementsText.contains(param)){
						isRowContainsParams = false;
					}
				}
				if(isRowContainsParams){
					return row;
				}
				isRowContainsParams = true;
			}
		}
		return null;
	}
}
