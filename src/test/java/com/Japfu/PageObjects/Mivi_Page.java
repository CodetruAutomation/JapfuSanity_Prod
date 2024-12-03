package com.Japfu.PageObjects;

import com.Japfu.common.CommonPageCICA;
import com.Japfu.utils.Reusablemethods;
import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;

public class Mivi_Page extends CommonPageCICA {

	//	private By employee = By.xpath("//img[@alt='employees']/following-sibling::span[.='Employees']");
	//	private By countOfEmployees = By.xpath("//div[text()='Count']");
	//	private By Filter = By.xpath("//button[@title='Filter']");
	//	private By employeeType = By.xpath("//div[text()='Employee Type']");
	//	private By consultantCheckbox = By.xpath("(//div[text()='Consultant'])[last()]");
	//	private By contractorCheckbox = By.xpath("(//div[text()='Contractor'])[last()]");
	//	private By applyFilter = By.xpath("//button[text()='Apply Filters']");
	//	private By clearFilter = By.xpath("//button[text()='Clear All']");
	//	private By internalEmployee = By.xpath("//button[text()='Internal Employees']");
	//	private By allEmployees = By.xpath("//button[text()='All Employees']");

	private By timesheet = By.xpath("//img[@alt='employees']/following-sibling::span[.='Timesheet']");
	private By countOfTimesheets = By.xpath("//div[text()='Count']");
	private By pendingApproval = By.xpath("//button[text()='Pending Approval']");
	private By approved = By.xpath("//button[text()='Approved']");
	private By rejected = By.xpath("//button[text()='Rejected']");
	//	private By chatResponse1 = By.xpath("//div[contains (text(),'timesheets are pending for approval.')]");
	//	private By chatResponse2 = By.xpath("//div[contains (text(),'The count of drafted timesheets is')]");

	private By miviTabClose = By.xpath("//img[@alt='suggestion']");
	private By miviResponse = By.xpath("(//div[text()='Mivi']/parent::div/parent::div/following-sibling::div/div)[last()]");
	//	private By internalEmployee = By.xpath("//button[text()='Internal Employees']");
	//	private By allEmployees = By.xpath("//button[text()='All Employees']");
	private By sendIcon = By.xpath("//*[local-name()='svg' and @data-testid='SendIcon']");
	//(//div[text()='Mivi']/parent::div/parent::div/following-sibling::div/div)[last()]
	private By miviBox = By.xpath("//img[@alt='suggestion']");
	private By miviIcon = By.xpath("//div[text()='Mivi']");
	private By creditsCount = By.xpath("//div[text()='AI Prompts']/preceding-sibling::div");
	private By mivichatfield = By.name("message");
	private By HarnessingLoading = By.xpath("//div[contains(text(),'Harnessing')]");

	public void Mivi_Chatbox_interaction() {

		clickElement(timesheet);
		sleep(1);
		String draftedCount = Reusablemethods.PickNumerics(getTextElement(countOfTimesheets));
		printStatement("Count of Drafted Timesheets - ", draftedCount);
		sleep(2);

		clickElement(pendingApproval);
		sleep(1);
		String TotalcountOfPendingApproval = Reusablemethods.PickNumerics(getTextElement(countOfTimesheets));
		printStatement("Count of Pending Timesheets for Approval - ", TotalcountOfPendingApproval);
		sleep(2);

		clickElement(approved);
		sleep(1);
		String TotalcountOfApprovedTimesheets = Reusablemethods.PickNumerics(getTextElement(countOfTimesheets));
		printStatement("Count of Approved Timesheets - ", TotalcountOfApprovedTimesheets);
		sleep(2);

		clickElement(rejected);
		sleep(1);
		String TotalcountOfRejectedTimesheets = Reusablemethods.PickNumerics(getTextElement(countOfTimesheets));
		printStatement("Count of Rejected Timesheets - ",TotalcountOfRejectedTimesheets );
		sleep(2);

		clickElement(miviBox);
		sleep(1);

		String creditsLeft = Reusablemethods.PickNumerics(getTextElement(creditsCount));
		int number = Integer.parseInt(creditsLeft);
		System.out.println("The Total Credits left is - "+number);


		if(number > 4) {
			if(verifyElementDisplayed(miviIcon)) {

				printStatement("Verify user able to open MIVI chat bot page - ", "User is on mivi page");	
			}else {
				printStatement("Verify user able to open MIVI chat bot page - ", "User unable to navigate to the mivi page");
			}
			sleep(1);

			setText(mivichatfield, "How many timesheets are drafted");
			sleep(1);
			clickElement(sendIcon);
			sleep(2);

			spinnerWaitWithTime(HarnessingLoading, 30);
			sleep(2);

			String data1 = Reusablemethods.PickNumerics(getTextElement(miviResponse));
			if(verifyElementDisplayed(miviResponse) && data1.equals(TotalcountOfApprovedTimesheets))  {
				printStatement("Verify MIVI Response - ", "Acual timesheets count and MIVI Response count Matched");
				printStatement("-----------******-----------", "-----------******-----------");

			}else {
				printStatement("Verify MIVI Response - ", "Unable to get response");
				printStatement("-----------******-----------", "-----------******-----------");
			}
			sleep(1);

			setText(mivichatfield, "How many timesheets are pending for approval");
			sleep(1);
			clickElement(sendIcon);
			sleep(5);
			String data2 = Reusablemethods.PickNumerics(getTextElement(miviResponse));
			if(verifyElementDisplayed(miviResponse) && data2.equals(TotalcountOfPendingApproval))  {
				printStatement("Verify MIVI Response - ", "Acual timesheets count and MIVI Response count Matched");	
				printStatement("-----------******-----------", "-----------******-----------");
			}else {
				printStatement("Verify MIVI Response - ", "Unable to get response");
				printStatement("-----------******-----------", "-----------******-----------");
			}
			sleep(1);

			setText(mivichatfield, "How many timesheets are approved");
			sleep(1);
			clickElement(sendIcon);
			sleep(4);
			String data3 = Reusablemethods.PickNumerics(getTextElement(miviResponse));
			if(verifyElementDisplayed(miviResponse) && data3.equals(draftedCount))  {
				printStatement("Verify MIVI Response - ", "Acual timesheets count and MIVI Response count Matched");	
				printStatement("-----------******-----------", "-----------******-----------");
			}else {
				printStatement("Verify MIVI Response - ", "Unable to get response");
				printStatement("-----------******-----------", "-----------******-----------");
			}
			sleep(1);

			setText(mivichatfield, "How many timesheets are rejected");
			sleep(1);
			clickElement(sendIcon);
			sleep(5);
			String data4 = Reusablemethods.PickNumerics(getTextElement(miviResponse));
			if(verifyElementDisplayed(miviResponse) && data4.equals(TotalcountOfRejectedTimesheets))  {
				printStatement("Verify MIVI Response - ","Acual timesheets count and MIVI Response count Matched");
				printStatement("-----------******-----------", "-----------******-----------");
			}else {
				printStatement("Verify MIVI Response - ", "Unable to get response");
				printStatement("-----------******-----------", "-----------******-----------");
			}

		} else {

			printStatement("Credits left: ", number+" - "+"Insufficient Credits");
			printStatement("-----------******-----------", "-----------******-----------");

		}


	}

	public void Unrecognized_Command() {

		String creditsLeft = Reusablemethods.PickNumerics(getTextElement(creditsCount));
		int number = Integer.parseInt(creditsLeft);
		System.out.println("The Total Credits left is - "+number);


		if(number > 2) {
			sleep(2);
			setText(mivichatfield, "what is my email");
			sleep(1);
			clickElement(sendIcon);
			sleep(3);
			if(verifyElementDisplayed(miviResponse))  {
				printStatement("Verify MIVI Response - ", getTextElement(miviResponse));
				printStatement("-----------******-----------", "-----------******-----------");
			}else {
				printStatement("Verify MIVI Response - ", "Unable to get response");
				printStatement("-----------******-----------", "-----------******-----------");
			}

			sleep(2);
			setText(mivichatfield, "qwertyuiopqwertyuiop");
			sleep(1);
			clickElement(sendIcon);
			sleep(3);
			if(verifyElementDisplayed(miviResponse))  {
				printStatement("Verify MIVI Response - ", getTextElement(miviResponse));
				printStatement("-----------******-----------", "-----------******-----------");
			}else {
				printStatement("Verify MIVI Response - ", "Unable to get response");
				printStatement("-----------******-----------", "-----------******-----------");
			}
		} else {

			printStatement("Credits left: ", number+" - "+"Insufficient Credits");
			printStatement("-----------******-----------", "-----------******-----------");

		}
		sleep(1);
		clickElement(miviTabClose);
		sleep(1);
	}

}


//clickElement(employee);
//sleep(1);
//String TotalcountOfEmployees = "54";//getTextElement(countOfEmployees);
//printStatement("Count of Total Employees in the Organization", TotalcountOfEmployees);
//sleep(2);
//
//clickElement(Filter);
//clickElement(employeeType);
//clickElement(consultantCheckbox);
//clickElement(applyFilter);
//sleep(1);
//String TotalcountOfConsultant = getTextElement(countOfEmployees);
//printStatement("Count of Total Consultant Employees in the Organization", TotalcountOfConsultant);
//sleep(2);
//
//clickElement(Filter);
//clickElement(employeeType);
//clickElement(clearFilter);
//clickElement(contractorCheckbox);
//clickElement(applyFilter);
//sleep(1);
//String TotalcountOfContractor = getTextElement(countOfEmployees);
//printStatement("Count of Total Contractor Employees in the Organization", TotalcountOfContractor);
//sleep(2);
//
//clickElement(internalEmployee);
//sleep(1);
//String TotalcountOfinternalEmployee = getTextElement(countOfEmployees);
//printStatement("Count of Total Internal Employees in the Organization", TotalcountOfinternalEmployee);
//sleep(2);
//clickElement(allEmployees);
//clickElement(employee);
