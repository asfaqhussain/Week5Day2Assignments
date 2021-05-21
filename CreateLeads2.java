package Week5.Day3;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeads2 extends BaseLeads {


		
		@DataProvider(name="TestData")
		public Object[][] fetchData() throws Exception{

			String sheetName="Createlead2";
			Object data[][]=ExcelDataread. exceldataread(sheetName);
			return data;
		}



	    @Test(dataProvider="TestData")
		public void createleads(String companyname,String firstname,String lastname) {
	    	driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
			driver.findElement(By.className("smallSubmit")).click();


		}

	

	}


