package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elements.EbayHome_Elements;
import steps.Common_Steps;

public class EbayHome_Actions {

	private WebDriver driver;
	EbayHome_Elements ebayHome_Elements;

	public EbayHome_Actions(Common_Steps common_Steps) {
		this.driver = common_Steps.getDriver();

		ebayHome_Elements = new EbayHome_Elements(driver);
	}

	public void clickAdvancedLink() {
		ebayHome_Elements.advancedLink.click();
	}

	public void searchAnItem(String srchString) {
		ebayHome_Elements.searchBox.sendKeys(srchString);
	}

	public void ClickSearchButton() {
		ebayHome_Elements.searchButon.click();
	}

	public int searchItemsCount() {

		String itemcount = ebayHome_Elements.numOfItems.getText().trim();
		String abc = itemcount.trim().replace(",", "");
		int itemcountint = Integer.parseInt(abc);
		return itemcountint;
	}

	public void selectCategory(String option) {
		List<WebElement> cat = ebayHome_Elements.catOptions;
		for (WebElement x : cat) {
			if (x.getText().trim().toLowerCase().equals(option.toLowerCase())) {
				x.click();
				break;
			}

		}

	}
	
	public void clickOnLinkByText(String Text) {
		
		driver.findElement(By.linkText(Text));
	}
}