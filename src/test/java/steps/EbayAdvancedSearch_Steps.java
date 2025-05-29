package steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayAdvancedSearch_Steps {

	//WebDriver driver;

	// dependency injection due to picopunder dependancy
	// create constructer first
	
	Common_Actions common_Actions;
	EbayAdvancedSearch_Actions ebayAdvancedSearch_Actions;
	
	public EbayAdvancedSearch_Steps(Common_Actions common_Actions,EbayAdvancedSearch_Actions ebayAdvancedSearch_Actions) {
	this.common_Actions=common_Actions;
	this.ebayAdvancedSearch_Actions=ebayAdvancedSearch_Actions;
		
	}
	

	@Given("I am on  Ebay Advanced Search Page")
	public void i_am_on_ebay_advanced_search_page() {

		//driver.get("https://www.ebay.com/sch/ebayadvsearch");
		
		common_Actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
	}

	@When("I click on Ebay Logo")
	public void i_click_on_ebay_logo() {
		//driver.findElement(By.xpath("//a[@id='gh-la']//*[name()='svg']")).click();
		
		ebayAdvancedSearch_Actions.clickOnEbayLogo();
	}

	@Then("I am navigated to Ebay Home Page")
	public void i_am_navigated_to_ebay_home_page() {

		String Expectedurl = "https://www.ebay.com/";
		
		String ActulURL = common_Actions.getCurrentPageUrl();
		if (!Expectedurl.equals(ActulURL)) {
			fail("page does not navigate to home page");
		}

	}

	@When("I advanced search an item")
	public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
		
		//driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
		ebayAdvancedSearch_Actions.enterSearchString(dataTable.cell(1, 0));
		
		//driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
		ebayAdvancedSearch_Actions.enterExcludeString(dataTable.cell(1, 1));
		//driver.findElement(By.cssSelector("input[id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox']")).sendKeys(dataTable.cell(1, 2));
		ebayAdvancedSearch_Actions.enterMinPrice(dataTable.cell(1, 2));
		//driver.findElement(By.cssSelector("input[id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox']")).sendKeys(dataTable.cell(1, 3));
		ebayAdvancedSearch_Actions.enterMaxPrice(dataTable.cell(1, 3));
		//driver.findElement(By.xpath("//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']")).click();
		ebayAdvancedSearch_Actions.clickOnSearch();
		Thread.sleep(3000);
	}

}
