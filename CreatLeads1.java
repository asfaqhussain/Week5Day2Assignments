package Week5.Day3;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreatLeads1 extends BaseLeads {

		
		 @DataProvider(name = "TestData")

			public Object[][] fetchData(){
				String[][]data = new String[2][3];

				data[0][0]= "TestLeaf";
				data[0][1]="Hari";
				data[0][2]="Krishna";

				data[1][0]= "Doggle ";
				data[1][1]="Babu";
				data[1][2]="Manikam";
				return data;
		 }


	    @Test(invocationCount = 3)
		public void  createleads() {
	    	driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Aspire Systems");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("JK");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("VAN");

			driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("ASE");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("xyz@gmail.com");
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("04434553");
			driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Chennai");

			driver.findElement(By.className("smallSubmit")).click();
	    }
	

	}


