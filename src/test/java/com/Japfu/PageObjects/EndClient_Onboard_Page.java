package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;

import com.Japfu.common.CommonPageCICA;
import com.Japfu.utils.DataGenerateUtils;


public class EndClient_Onboard_Page extends CommonPageCICA{

	private By clients = By.xpath("//img[@alt='ledger']");
	private By endclients = By.xpath("//div[.='End Clients']");
	private By addEndClient = By.xpath("//img[@alt='plus']");
	private By endClientName = By.xpath("//label[.='End Client Name']/following-sibling::div/input[@type='text']");
	private By clientId = By.name("reference_id");
	//	private By address1 = By.name("address_line_one");
	//	private By state = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	//	private By alabama = By.xpath("//li[.='Alabama']");
	//	private By city = By.name("city");
	private By saveButton = By.xpath("//button[.='Save & Continue']");
	//private By zipcode = By.name("zip_code");
	private By firstName = By.name("first_name");
	private By lastName = By.name("last_name");
	private By email = By.name("email_id");
	private By phoneNumber = By.name("telephone_number");
	private By finishButton = By.xpath("//button[text()='Finish']");
	private By completionMessage = By.xpath("//div[.='Succesfully Added!']");
	private By goToHome = By.xpath("//button[.='Go To Home']");
	private By mandatoryErrorMessage = By.xpath(
			"//div[text()='One or more fields are invalid. Please check the highlighted areas and correct the errors to proceed.']");
	private By existingClient = By.xpath("//div/div[text()='End Client name already exist']");
	private By closeToastMsg = By.xpath("//*[local-name()='svg' and  @data-testid='CloseIcon']//*[local-name()='path']");
	//	private By paymentTrems = By.xpath("//label[.='Payment Terms']/following-sibling::div/input[@type='text']");
	private By successMessage = By.xpath("//div[text()='Success']");

	public static String endclientname;
	public static String fname;
	public static String Lname;

	public void Add_EndClient() {
		sleep(2);
		clickElement(clients);
		sleep(0.75);
		clickElement(endclients);
		sleep(0.75);
		clickElement(addEndClient);

	}

	public void InvalidEmail() {
		sleep(2);
		moveToElement(saveButton);
		sleep(0.75);
		clickElement(saveButton);

		if(verifyElementDisplayed(mandatoryErrorMessage)) {
			printStatement("Without entering any details in the Client page the error message is ", 
					"'"+getWebElement(mandatoryErrorMessage).getText()+"'");
		} else {
			printStatement("Without entering any details in the page the error message is - ", "No Error message is displayed");
		}
	}

	public void End_Client_Information() {

		sleep(2);
		endclientname = DataGenerateUtils.randomMiddleName();
		//scrollToElementAtTop(endClientName);
		sleep(1);
		setText(endClientName, endclientname); 
		System.out.println("Client Name ="+endclientname);
		System.out.println(getTextElement(clientId));
		//		String addressOne = DataGenerateUtils.randomStreetName();
		//		System.out.println("New Address - "+addressOne);
		//		setText(address1, addressOne);
		//		moveToElement(saveButton);
		//		clickElement(state);
		//		clickElement(alabama);
		//		setText(city, DataGenerateUtils.randomCity());
		//		setText(zipcode, DataGenerateUtils.randomZipCode());

		sleep(1);
		moveToElement(saveButton);
		sleep(0.5);
		clickElement(saveButton);
		sleep(1);
		
		try {
			verifyElementDisplayed(successMessage);
			sleep(0.5);
			clickElement(closeToastMsg);

		} catch (Exception e) {
			verifyElementDisplayed(existingClient);
			sleep(0.5);
			clickElement(closeToastMsg);
			sleep(1);
			scrollToPageTop();
			//scrollToElementAtTop(endClientName);
			sleep(1);
			KeyBoardPress_ClearField(endClientName);
			sleep(0.5);
			setText(endClientName, endclientname); 
			sleep(1);
			scrollToPageBottom();
			moveToElement(saveButton);
			sleep(0.5);
			clickElement(saveButton);
		}
		sleep(3);
	}

	public void End_Client_Contact_Information() {
		scrollToPageTop();
		sleep(1);
		fname = DataGenerateUtils.randomFirstName();
		Lname=DataGenerateUtils.randomLastName();
		setText(firstName, fname); 
		sleep(0.5);
		setText(lastName, Lname);
		sleep(0.5);
		setText(email, DataGenerateUtils.randomEmail());
		sleep(0.5);
		setText(phoneNumber, DataGenerateUtils.randomPhoneNumber());
		sleep(1);
		moveToElement(finishButton);
		sleep(3);
		clickElement(finishButton);
	}

	public void EndClient_Onboard_Completion() {
		sleep(1);
		verifyElementVisible(completionMessage);
		sleep(0.5);
		clickElement(goToHome);
	}



}



