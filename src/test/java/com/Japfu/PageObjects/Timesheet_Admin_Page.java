package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Japfu.driver.DriverManager;

public class Timesheet_Admin_Page {

	private By timesheet = By.xpath("//span[.='Timesheet']");
	private By addTimesheet = By.id("add-timesheet");
	private By selectEmpDrpdwn = By.xpath("(//button[@title='Open'])[1]");
	private By nextIcon = By.xpath("//button[@title='Next month']");
	private By calenderBtn = By.xpath("//label[.='Start Date']/following-sibling::div/div/button");
	private By cancelButton = By.xpath("(//button[.='Cancel'])[5]");
	private By submitButton = By.xpath("//button[.='Submit']");
	private By timesheetExistsPopup = By.xpath("//div[contains(text(), 'Timesheet Already Exists')]");
	private By closeBtn = By.xpath("//button[@aria-label='close']");
	private By doneBtn = By.xpath("(//button[text()='Done'])[2]");
	private By viewBtn = By.xpath("(//div[text()='View'])[1]");
	private By pendingApproval = By.xpath("//button[text()='Pending Approval']");
	//	private By editBtn = By.xpath("//button[text()='Edit']");
	//	private By reSubmitBtn = By.xpath("//button[text()='Resubmit']");
	private By approvalBtn = By.xpath("//button[text()='Approve']");
	private By gotoHomeBtn = By.xpath("//button[text()='Go To Home']");
	private By empName = By.xpath("(//div[contains(@class,'MuiTypography-root')])[1]");
	private By approvedScreen = By.xpath("//button[text()='Approved']");
	private By searchBox = By.xpath("//input[contains(@placeholder, 'Search by Name')]");
	private By approvalStatus = By.xpath("//div[text()='Approved']");
	private By rejectBtn = By.xpath("//button[text()='Reject']");
	private By comment = By.xpath("//input[@name='rejectComment']");
	private By yesBtn = By.xpath("//button[text()='Yes, Reject']");
	private By rejectedScreen = By.xpath("//button[text()='Rejected']");
	private By rejectedStatus = By.xpath("//div[text()='Rejected']");
	private By featureTimesheetErrorMsg = By.xpath("//div[text()='Not allowed to approve future timesheets']");
	private By approvedTimesheetpopup = By.xpath("//div[text()='Timesheet Approved!']");
	private By svgCloseBtn = By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']//*[local-name()='path']");
	private By UpdatedDOB = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	private By okButton = By.xpath("//button[text()='OK']");

	private By placementFieldValue = By.xpath("//label[text()='Select Placement ID']/following-sibling::div/input");
//	private By selectPlacement = By.xpath("//div[text()='Not allowed to approve future timesheets']");
//	private By placementID = By.xpath("//div[text()='Timesheet Approved!']");



	public static String approvedEmpname;
	public static String rejectedEmpname;


	public void OpenTimesheetPage() {

		sleep(2);
		clickElement(timesheet);
		sleep(3);

	}

	public void navigate_to_addNewTimesheet() {
		
		sleep(1);
		clickElement(addTimesheet);
		sleep(2);
		clickElement(selectEmpDrpdwn);
		sendKeys_perform(Keys.ENTER);
		sleep(1);

		if(getAttributeElement(placementFieldValue,"value").isEmpty()) {

			clickElement(placementFieldValue);
			sleep(0.5);
			sendKeys_perform(Keys.ENTER);
			sleep(0.5);
			printStatement("Verify Number of Placements of an Employee", "Multiple Placements");
			
		} else if(getAttributeElement(placementFieldValue,"value").contains("PLS")) {
			
			printStatement("Verify Number of Placements of an Employee", "Only one Placement");
			
		}
	}

	public void add_New_Future_Timesheet() {

		boolean shouldBreak = false;

		for (int i = 0; i <= 10; i++) {
			sleep(2);
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
				if (j!= 1) {
					clickElement(calenderBtn);
					sleep(1);
					
				}

				WebElement data1 = DriverManager.getDriver().findElement(By.xpath("//button[text()='" + xp + "']"));
				System.out.println("The value of the xpath is -" + xp);
				data1.click();
				sleep(1);

				if (DriverManager.getDriver().findElement(timesheetExistsPopup).isDisplayed()) {
					sleep(2);
					clickElement(cancelButton);
					sleep(2);
					clickElement(submitButton);
					sleep(1);
					clickElement(closeBtn);
					sleep(1);
				} else {
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

	public void submit_Timesheet() {
		sleep(2);
		clickElement(viewBtn);
		sleep(2);
		moveToElement(submitButton);
		clickElement(submitButton);
		sleep(2);
		verifyElementDisplayed(doneBtn);
		clickElement(doneBtn);

	}

	public void approval_Timesheet() {

		for (int i = 1; i <= 30; i++) {
			sleep(1);
			clickElement(pendingApproval);
			sleep(2);

			WebElement viewBtn = DriverManager.getDriver().findElement(By.xpath("(//div[text()='View'])[" + i + "]"));
			scrollToElementAtTop(viewBtn);
			sleep(1);

			if (!viewBtn.isDisplayed()) {
				printStatement("There are no current month's timesheets available for approval.",
						"Please add the timesheets for this month to proceed with approval.");
			}

			viewBtn.click();
			sleep(2);
			scrollToPageBottom();
			sleep(1);

			//DriverManager.getDriver().findElement(approvalBtn).isDisplayed())
			moveToElement(approvalBtn);
			sleep(0.5);
			scrollToElementAtBottom(approvalBtn);
			sleep(0.5);
			scrollToPageTop();

			approvedEmpname = getWebElement(empName).getText();
			sleep(0.5);
			scrollToPageBottom();
			sleep(0.5);

			clickElement(approvalBtn);
			sleep(1);

			if(verifyElementVisible(approvedTimesheetpopup)) {
				sleep(1);
				clickElement(gotoHomeBtn);
				printStatement("Timeshet Approved for employee : ", approvedEmpname);
				sleep(0.5);
				break;

			}else if(verifyElementVisible(featureTimesheetErrorMsg)) {
				sleep(0.5);
				clickElement(svgCloseBtn);
				sleep(1);
				DriverManager.getDriver().navigate().back();
				sleep(1);
			}

		}

		sleep(1);
		clickElement(approvedScreen);
		sleep(1);
		String[] afterSlipt = approvedEmpname.split("");
		getWebElement(searchBox).sendKeys(afterSlipt[0]);
		sleep(1);
		clickElement(viewBtn);
		sleep(1);
		verifyElementPresent(approvalStatus);
		sleep(1);
		DriverManager.getDriver().navigate().back();
		sleep(2);

	}

	public void rejet_Timesheet() {
		for (int xp = 1; xp <= 30; xp++) {
			sleep(1);
			clickElement(pendingApproval);
			sleep(2);
			WebElement viewBTn1 = DriverManager.getDriver().findElement(By.xpath("(//div[text()='View'])["+xp+"]"));
			sleep(1);
			scrollToElementAtTop(viewBTn1);
			sleep(1);
			viewBTn1.click();
			sleep(2);
			scrollToPageBottom();
			sleep(1);

			try {
				if(DriverManager.getDriver().findElement(rejectBtn).isDisplayed()) {
					sleep(2);
					moveToElement(rejectBtn);
					sleep(0.5);
					scrollToElementAtBottom(rejectBtn);
					sleep(0.5);
					scrollToPageTop();
					rejectedEmpname = getWebElement(empName).getText();
					printStatement("Timeshet reject for employee : ", rejectedEmpname);
					sleep(0.5);
					scrollToPageBottom();
					sleep(0.5);
					clickElement(rejectBtn);
					sleep(1);
					setText(comment, "Time entries include hours logged outside standard business hours, Please submit again");
					sleep(1);
					clickElement(yesBtn);
					sleep(1);
					clickElement(gotoHomeBtn);
					break;
				}
			} catch (Exception e) {
				sleep(1);
				DriverManager.getDriver().navigate().back();
				sleep(1);
			}
		}
		sleep(1);
		clickElement(rejectedScreen);
		sleep(0.5);
		String [] aftersplit = rejectedEmpname.split(" ");
		getWebElement(searchBox).sendKeys(aftersplit[0]);
		sleep(0.5);
		clickElement(viewBtn);
		sleep(1);
		verifyElementPresent(rejectedStatus);	

		sleep(1);
		DriverManager.getDriver().navigate().back();
		sleep(1);
	}


}
