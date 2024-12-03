package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.driver.DriverManager;

public class TimesheetAttacment_Page  extends CommonPageCICA {

	private By timesheet = By.xpath("//span[.='Timesheet']");
	private By addTimesheet = By.id("add-timesheet");
	private By nextIcon = By.xpath("//button[@title='Next month']");
	private By calenderBtn = By.xpath("//label[.='Start Date']/following-sibling::div/div/button");
	private By cancelButton = By.xpath("(//button[.='Cancel'])[5]");
	private By submitButton = By.xpath("//button[.='Submit']");
	private By timesheetExistsPopup = By.xpath("//div[contains(text(), 'Timesheet Already Exists')]");
	private By closeBtn = By.xpath("//button[@aria-label='close']");
	private By doneBtn = By.xpath("(//button[text()='Done'])[last()]");
	private By viewBtn = By.xpath("(//div[text()='View'])[1]");
	private By errorMsg = By.xpath("//div[text()='Upload document Format JPEG/PNG']");
	//private By breadCrum = By.xpath("//p[text()='Timesheet']");


	public static String approvedEmpname;
	public static String rejectedEmpname;


	public void navigate_To_Timesheet_Page() {

		sleep(2);
		clickElement(timesheet);
		sleep(3);
	}

	public void navigate_to_addNewTimesheet() {
		sleep(1);
		clickElement(addTimesheet);
	}
	
	public void add_New_Future_Timesheet() {

		boolean shouldBreak = false;

		for (int i = 0; i <= 10; i++) {
			sleep(1);
			clickElement(calenderBtn);
			sleep(1);
			clickElement(nextIcon);
			for (int j = 1; j <= 4; j++) {
				if (shouldBreak) break;  

				sleep(1);
				int number = 1;
				int xp;
				if (j == 1) {
					xp = number;
				} else if (j == 2) {
					xp = number + 7;
				} else if (j == 3) {
					xp = number + 14;
				} else {
					xp = number + 21;
				}

				sleep(1);
				if (j != 1) {
					clickElement(calenderBtn);
					sleep(2);
				}

				WebElement data1 = DriverManager.getDriver().findElement(By.xpath("//button[text()='" + xp + "']"));
				System.out.println("The value of the xpath is -" + xp);
				data1.click();
				sleep(1);

				if (DriverManager.getDriver().findElement(timesheetExistsPopup).isDisplayed()) {
					sleep(1);
					clickElement(cancelButton);
					sleep(2);
					clickElement(submitButton);
					sleep(1);
					clickElement(closeBtn);
					sleep(1);
					
				} else {
					
					String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//I9 Document.jpg";
					WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
					sleep(1);
					fileInput.sendKeys(filePath);
					clickElement(submitButton);
					sleep(1);
					clickElement(doneBtn);
					shouldBreak = true;  
					break;
				}
			}
			if (shouldBreak) break;  
		}
	}
	
	public void add_Timesheet_With_ValidFile() {
		sleep(2);
		clickElement(viewBtn);
		sleep(2);
		
		String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//AI_Timesheet_SS//AI_sheet_SS.png";
		WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
		sleep(1);
		fileInput.sendKeys(filePath);
		
		moveToElement(submitButton);
		clickElement(submitButton);
		sleep(1);
		clickElement(doneBtn);

	}


	
	public void add_Timesheet_With_invalidFile() {
		
		sleep(2);
		clickElement(viewBtn);
		sleep(2);
		
		String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//Login.xlsx";
		WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
		sleep(1);
		fileInput.sendKeys(filePath);
		String Actaulerror = getTextElement(errorMsg);
		assertEquals(Actaulerror, "Upload document Format JPEG/PNG");
		sleep(1);
		scrollToPageTop();
		sleep(0.5);
		//clickElement(breadCrum);
		
	}

}
