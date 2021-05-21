package Week5.Day3;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLeads1 extends BaseLeads {

	
		
		@DataProvider(name="TestData")
		public Object[][] fetchData() throws Exception{

			String sheetName="Editleads1";
			Object data[][]=ExcelDataread. exceldataread(sheetName);
			return data;
		}


		@Test(dataProvider="TestData")
		public  void editleads(String companyname,String firstname) throws InterruptedException {

			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("(//div//input[@name='firstName'])[3]")).sendKeys(firstname);

			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tbody//tr[1]//td[1]//a)[1]")).click();
			Thread.sleep(1000);
			String TitlePage = driver.getTitle();

			if (TitlePage.equalsIgnoreCase("View Lead | opentaps CRM")) {
				System.out.println("Test case passed");
			} else {
				System.out.println("Test  case failed");
			}
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
			driver.findElement(By.className("smallSubmit")).click();
			String ChangedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			System.out.println("Updated company name : " + ChangedName);
			String UpdatedName = ChangedName.replaceAll("[^a-zA-Z]", "");
			System.out.println("Replaced company name : " + UpdatedName);
			if (UpdatedName.equals("Quadrant")) {
				System.out.println("verified");
			} else {
				System.out.println("not verified");
			}

		}

	

	}


