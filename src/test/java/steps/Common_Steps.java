package steps;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import actions.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common_Steps {

	private WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		 System.out.println("Global Before Hook Executed");
	}
	
	@After
	public void tearDown(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			//Take Screenshot
			final byte[] shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//Embed into Report
			scenario.attach(shot, "image/png", scenario.getName());
		}
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	@Then("I read excel data")
	public void i_read_excel_data() throws IOException {
      //  DataTable dataTable = ExcelReader.getDataTable("src/test/resources/data.xlsx", "Sheet1");
		List<Map<String, String>> excelData = ExcelReader.getDataTable("src/test/resources/data.xlsx", "Sheet1");

//        List<Map<String, String>> rows = dataTable.asMaps();
//
//        for (Map<String, String> row : rows) {
//            System.out.println("Username: " + row.get("Username") + ", Password: " + row.get("Password"));
		
		for (Map<String, String> row : excelData) {
	        String Email = row.get("Email");
	        String expectedText = row.get("Expected Text");
	        System.out.println(Email + expectedText);

	     //   driver.get("https://example.com/welcome?user=" + name);
	       // String actualText = driver.findElement(By.id("welcome-msg")).getText();

	        //Assert.assertEquals(actualText, expectedText, "Text mismatch for " + name);
        }
    }
	
	

	@Then("I update excel sheet {string} in row {int} and column {int} of {string} in file {string}")
	public void i_update_excel_sheet_in_row_and_column_of_in_file(String value, Integer rowNum, Integer colNum, String sheetName, String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // Create row if it doesn't exist
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        // Create cell if it doesn't exist
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }

        cell.setCellValue(value);

        // Close input stream before writing
        fis.close();

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
	
	@Then("I update excel sheet {string} in row {string} and column\"{int}\" of \"Sheet1\" in file \"src\\/test\\/resources\\/data.xlsx\"")
	public void i_update_excel_sheet_in_row_and_column_of_sheet1_in_file_src_test_resources_data_xlsx(String value, Integer rowNum, Integer colNum, String sheetName, String filePath) throws IOException {
		
	//(String value, Integer rowNum, Integer colNum, String sheetName, String filePath) throws IOException	
		FileInputStream fis = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet(sheetName);

	        // Create row if it doesn't exist
	        Row row = sheet.getRow(rowNum);
	        if (row == null) {
	            row = sheet.createRow(rowNum);
	        }

	        // Create cell if it doesn't exist
	        Cell cell = row.getCell(colNum);
	        if (cell == null) {
	            cell = row.createCell(colNum);
	        }

	        cell.setCellValue(value);

	        // Close input stream before writing
	        fis.close();

	        FileOutputStream fos = new FileOutputStream(filePath);
	        workbook.write(fos);
	        workbook.close();
	        fos.close();
	}

	


	}



	
	

