package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearch_Elements {

	
	WebDriver driver;
	
	public EbayAdvancedSearch_Elements(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@id='gh-la']//*[name()='svg']") public WebElement ebaLogo;
	@FindBy(xpath="//input[@id='_nkw']") public WebElement searchString;
	@FindBy(xpath="//input[@id='_ex_kw']") public WebElement excludeString;
	@FindBy(css="input[id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox']") public WebElement minPrice;
	@FindBy(css="input[id='s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox']") public WebElement maxPrice;
	@FindBy(xpath="//div[@class='adv-form__actions']//button[@type='submit'][normalize-space()='Search']") public WebElement searchButton;
	
	
	
	
	
	
}
