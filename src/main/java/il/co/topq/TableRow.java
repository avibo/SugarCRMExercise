package il.co.topq;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TableRow {
	
	private WebDriver driver;
	private int tableRowIndex;
	private String tableRowXpathLocator;

	public TableRow(WebDriver driver, int tableRowIndex, String tableRowXpathLocator){
		this. driver = driver;
		this.tableRowIndex = tableRowIndex;
		this.tableRowXpathLocator = tableRowXpathLocator;
	}
	
	public List<String> getRowText(){
		List<WebElement> rowEelements = driver.findElements(By.xpath(tableRowXpathLocator + "[" + tableRowIndex +"]/td"));
		List<String> rowEelementsText = new ArrayList<>(); 
		for(WebElement rowEelement : rowEelements){
			rowEelementsText.add(rowEelement.getText());
		}
		return rowEelementsText;
	}
}
