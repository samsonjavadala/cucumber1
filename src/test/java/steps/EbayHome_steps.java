package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import actions.Common_Actions;
import actions.EbayHome_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_steps {

	//WebDriver driver;

	// dependency injection due to picopunder dependancy
	// create constructer first
	
	EbayHome_Actions ebayHome_Actions;
	Common_Actions common_Actions;
	

	public EbayHome_steps(Common_Actions common_Actions,EbayHome_Actions ebayHome_Actions) {
		this.common_Actions=common_Actions;
		this.ebayHome_Actions=ebayHome_Actions;
	}

	@Given("I am on Ebay Home Page")
	public void i_am_on_ebay_home_page() {

		//driver.get("https://www.ebay.com/");
		common_Actions.goToUrl("https://www.ebay.com/");

	}

	@When("I click on Advanced Link")
	public void i_click_on_advanced_link() {
		//driver.findElement(By.linkText("Advanced")).click();
		ebayHome_Actions.clickAdvancedLink();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_advanced_search_page() {
		String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
		String actUrl = common_Actions.getCurrentPageUrl();
		if (!expUrl.equals(actUrl)) {
			fail("Page does not navigae to expected page");
		}

	}

	@When("I serach for {string}")
	public void i_serach_for_i_phone(String str1) {
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
		ebayHome_Actions.searchAnItem(str1);
		//driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		ebayHome_Actions.ClickSearchButton();
	}

	@Then("I validate atleast {int} search items present")
	public void i_validate_atleast_search_items_present(int count) {
		//String itemcount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child"))
		//		.getText();
		int itemcount = ebayHome_Actions.searchItemsCount();
				
		//String abc = itemcount.trim().replace(",", "");
		//int itemcountint = Integer.parseInt(abc);
		if (!(itemcount >= count)) {
			fail("lesst than" + " " + count + " " + "results shown");
		}

	}

	@When("I serach for {string} in {string} category")
	public void i_serach_for_in_category(String string, String string2) throws InterruptedException {
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
		ebayHome_Actions.searchAnItem(string);
		//driver.findElement(By.xpath("//select[@id='gh-cat']")).click();
		
		/***
		List<WebElement> cat=driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		for(WebElement x:cat) {
			if(x.getText().trim().toLowerCase().equals(string2.toLowerCase())) {
				x.click();
				break;
				
			}
			
		}*///
		ebayHome_Actions.selectCategory(string2);
		ebayHome_Actions.ClickSearchButton();
		Thread.sleep(3000);
	}
	

	@When("I click on {string}")
	public void i_click_on(String string) {
	  //  driver.findElement(By.linkText(string)).click();
		ebayHome_Actions.clickOnLinkByText(string);
	}
	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_page_contains_ebay_motors(String url, String title) {
	   String ActlURL= common_Actions.getCurrentPageUrl();
	   String actTitle= common_Actions.getCurrentPageTitle();
	   if(!ActlURL.equals(url)) {
		  fail("page does not navigate to "+ url ) ;
	   }
	   if(!actTitle.contains(title)) {
		   fail("Title mismatch" ) ; 
	   }
	}



}
