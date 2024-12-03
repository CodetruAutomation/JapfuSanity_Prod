package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.Reusablemethods;


public class Timesheet_AI_Page extends CommonPageCICA {

	private By timesheet = By.xpath("//span[.='Timesheet']");
	private By viewBtn = By.xpath("//div[text()='View']");
	private By empName = By.xpath("(//div[contains(@class,'MuiTypography-root')])[1]");

	private By timesheetTable = By.xpath("//tr[contains(@class,'MuiTableRow-head')]/th");
	private By creditsCount = By.xpath("//div[text()='AI Timesheets']/preceding-sibling::div");
	private By captureTimesheet = By.xpath("//div[text()='Capture']");
	private By oopsPopup = By.xpath("//div[text()='OOPS!']");
	private By okButton = By.xpath("//button[text()='Ok']");
	private By doneButton = By.xpath("//button[text()='Done']");
	private By okayButton = By.xpath("//button[text()='Okay']");
	private By mismatchAlert = By.xpath("//div[text()='Name Mismatch Alert!']");
	private By errorPopup = By.xpath("//div[contains(text(),'Invalid response ,please try again')]");
	private By submitButton = By.xpath("//button[text()='Submit']");

	private By submitSuccessMessage = By.xpath("//div[contains(text(),'Timesheet Submitted Successfully')]");
	private By submitDoneButton = By.xpath("(//button[text()='Done'])[2]");

	private By pendingApproval = By.xpath("//button[text()='Pending Approval']");
	private By approvalBtn = By.xpath("//button[text()='Approve']");
	private By gotoHomeBtn = By.xpath("//button[text()='Go To Home']");
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
	
	
private By HarnessingLoading = By.xpath("//div[contains(text(),'Harnessing')]");
	
	
	public void openTimesheetsPage() {
		sleep(2);
		clickElement(timesheet);
		sleep(1);
	}
 
	public void AI_TimesheetsVerification() throws Exception {
		
		clickElement(viewBtn);
		sleep(1);
 
		String creditsLeft = Reusablemethods.PickNumerics(getTextElement(creditsCount));
		int number = Integer.parseInt(creditsLeft);
		System.out.println("The Total Credits left is - "+number);
 
		if(number >= 1) {
 
			String employeeName = getTextElement(empName);
 
			ExcelHelpers exc = new ExcelHelpers();
			exc.setExcelFile(FrameworkConstants.EXCEL_AI_TIMESHEETS_XLSX, "AI_Timesheets");
			exc.setCellData(employeeName, 5, 3);
			sleep(2);
 
			scrollToPageBottom();
			sleep(1);
			List<WebElement> tablerow = getWebElements(timesheetTable);
			System.out.println("Table Size = "+tablerow.size());
 
			for (int i =2; i<tablerow.size(); i++) {
				int count = i-1;
 
				By columnText = By.xpath("(//tr[contains(@class,'MuiTableRow-head')])/th["+i+"]/div[2]");
				System.out.println("Day -"+count+"-"+getTextElement(columnText));
				exc.setCellData(getTextElement(columnText),i+7 , 2);
 
			}
			sleep(2);
 
			exc.convertExcelToHtml(FrameworkConstants.EXCEL_AI_TIMESHEETS_XLSX, FrameworkConstants.EXCEL_AI_TIMESHEETS_HTML);
			sleep(1);
			openNewTab();
			sleep(1);
			DriverManager.getDriver().get(new File(FrameworkConstants.EXCEL_AI_TIMESHEETS_HTML).toURI().toString());
 
			sleep(1);
 
			takeFullPageScreenshotWithoutDate("AI_sheet_SS");
			sleep(2);
 
			switchToMainWindow();
			sleep(1);
 
			String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//AI_Timesheet_SS//AI_sheet_SS.png";
			WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
			sleep(1);
			fileInput.sendKeys(filePath);
			sleep(2);
			clickElement(captureTimesheet);
			sleep(2);
			
			spinnerWaitWithTime(HarnessingLoading, 30);
			sleep(2);
			try {
				verifyElementVisible(doneButton);
				sleep(2);
				clickElement(doneButton);
				sleep(1);
				scrollToPageBottom();
				sleep(1);
				clickElement(submitButton);
				sleep(1);
				if(verifyElementDisplayed(submitSuccessMessage)) {
					clickElement(submitDoneButton);
					printStatement("Timesheet Submision Status - ", "AI Timesheet Submitted Successfully");
				}else {
					printStatement("Timesheet Submision Status - ", "Unable to Submit AI Timesheet");
				}
 
			} catch (Exception e) {
 
				if(verifyElementDisplayed(errorPopup)){
					printStatement("Image upload response - ", getTextElement(errorPopup));
 
				}else if(verifyElementDisplayed(mismatchAlert)) {
					clickElement(okayButton);
 
				}else if(verifyElementDisplayed(oopsPopup)){
					clickElement(okButton);
				}
 
			}
 
		} else {
 
			printStatement("Credits left: ", number+" - "+"Insufficient Credits");
			printStatement("-----------******-----------", "-----------******-----------");
 
		}
	}

	public void AI_InvalidTimesheet() throws Exception {

		sleep(1);
		clickElement(viewBtn);
		sleep(1);

		String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//images.png";
		WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
		sleep(1);
		fileInput.sendKeys(filePath);
		sleep(2);
		clickElement(captureTimesheet);
		sleep(1);

		if(verifyElementVisible(errorPopup)){
			printStatement("Image upload response - ", getTextElement(errorPopup));

		}else if(verifyElementVisible(doneButton)) {
			clickElement(doneButton);

		}
		sleep(1);
		DriverManager.getDriver().navigate().back();
		sleep(2);
	}

	public static String approvedEmpname;

	public void approval_AI_Timesheet() {


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
			sleep(2);


			if(	DriverManager.getDriver().findElement(approvedTimesheetpopup).isDisplayed()) {
				sleep(1);
				clickElement(gotoHomeBtn);
				printStatement("Timeshet Approved for employee : ", approvedEmpname);
				sleep(0.5);
				break;

			}else if(DriverManager.getDriver().findElement(featureTimesheetErrorMsg).isDisplayed()) {
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

	public static String rejectedEmpname ;

	public void Rejet_AI_Timesheet() {

		for(int xp=1;xp<=30;xp++) {
			sleep(1);
			clickElement(pendingApproval);
			sleep(2);
			WebElement viewBTn1 = DriverManager.getDriver().findElement(By.xpath("(//div[text()='View'])["+xp+"]"));
			sleep(1);
			scrollToElementAtTop(viewBTn1);
			sleep(1);
			viewBTn1.click();
			sleep(1);
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

	private By mandateErrorRejectReason=By.xpath("//div[text()='This field is required']");
	private By cancelButton=By.xpath("(//button[text()='Cancel'])[last()]");

	public void Reject_AI_Timesheet_Missing_reject_Reason() {

		for(int xp=1;xp<=30;xp++) {
			sleep(1);
			clickElement(pendingApproval);
			sleep(2);
			WebElement viewBTn1 = DriverManager.getDriver().findElement(By.xpath("(//div[text()='View'])["+xp+"]"));
			sleep(1);
			scrollToElementAtTop(viewBTn1);
			sleep(1);
			viewBTn1.click();
			sleep(1);
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
					sleep(1);
					scrollToPageBottom();
					sleep(2);
					clickElement(rejectBtn);
					sleep(1);
					//setText(comment, "Time entries include hours logged outside standard business hours, Please submit again");
					//sleep(1);
					clickElement(yesBtn);
					sleep(1);

					if(verifyElementDisplayed(mandateErrorRejectReason)) {
						sleep(1);
						printStatement("Verify without entering any reason error message is displayed for mandator field - ", getTextElement(mandateErrorRejectReason));
						clickElement(cancelButton);
						break;
					} else {
						printStatement("Verify without entering any reason error message is displayed for mandator field - ", getTextElement(mandateErrorRejectReason));
					}

				}

			} catch (Exception e) {
				sleep(1);
				DriverManager.getDriver().navigate().back();
				sleep(1);
			}
		}
		sleep(1);
		DriverManager.getDriver().navigate().back();
		sleep(1);

	}

}
