package Week5.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MergeLeads extends BaseLeads {

		
		
		@DataProvider(name="TestData")
		public Object[][] fetchData() throws Exception{

			String sheetName="MergeLeads";
			Object data[][]=ExcelDataread. exceldataread(sheetName);
			return data;

		}
		@Test(dataProvider="TestData")


		public void mergeleads() throws InterruptedException {


			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Merge Leads")).click();
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			Thread.sleep(2000);
			Set<String> ParentWindow = driver.getWindowHandles();
			List<String> window1 = new ArrayList<String>(ParentWindow);
			driver.switchTo().window(window1.get(1));
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			driver.switchTo().window(window1.get(0));
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Thread.sleep(2000);
			ParentWindow = driver.getWindowHandles();
			List<String> window2 = new ArrayList<String>(ParentWindow);
			driver.switchTo().window(window2.get(1));
			driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]")).click();
			driver.switchTo().window(window2.get(0));
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();

		}

	

	}


