package actions;

import org.openqa.selenium.WebDriver;

import elements.EbayAdvancedSearch_Elements;
import steps.Common_Steps;

public class EbayAdvancedSearch_Actions {
	
	
	private WebDriver driver;
	
	EbayAdvancedSearch_Elements ebayAdvancedSearch_Elements;
	
	public EbayAdvancedSearch_Actions(Common_Steps common_Steps) {
		this.driver=common_Steps.getDriver();
		ebayAdvancedSearch_Elements= new EbayAdvancedSearch_Elements(driver);
		
	}

	public void clickOnEbayLogo() {
		ebayAdvancedSearch_Elements.ebaLogo.click();
	}
	
	public void enterSearchString(String string) {
		ebayAdvancedSearch_Elements.searchString.sendKeys(string);
	}
	
	public void enterExcludeString(String string) {
		ebayAdvancedSearch_Elements.excludeString.sendKeys(string);
	}
	public void enterMinPrice(String string) {
		ebayAdvancedSearch_Elements.minPrice.sendKeys(string);
	}
	public void enterMaxPrice(String string) {
		ebayAdvancedSearch_Elements.maxPrice.sendKeys(string);
	}
	public void clickOnSearch() {
		ebayAdvancedSearch_Elements.searchButton.click();
	}
}
