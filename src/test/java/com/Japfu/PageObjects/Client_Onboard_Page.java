package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.Japfu.common.CommonPageCICA;
import com.Japfu.driver.DriverManager;
import com.Japfu.utils.DataGenerateUtils;

public class Client_Onboard_Page extends CommonPageCICA{

	private By clients = By.xpath("//img[@alt='ledger']");
	private By addClient = By.xpath("//img[@alt='plus']");
	private By clientName = By.xpath("//label[.='Client Name']/following-sibling::div/input[@type='text']");
	private By clientId = By.name("reference_id");
	private By address1 = By.name("address_line_one");

	private By successMessage = By.xpath("//div[text()='Success']");
	private By existingClient = By.xpath("//div[text()='Client name already exist']");
	private By saveButton = By.xpath("//button[.='Save & Continue']");
	private By zipcode = By.name("zip_code");
	private By firstName = By.name("first_name");
	private By lastName = By.name("last_name");
	private By email = By.name("email_id");
	private By phoneNumber = By.name("telephone_number");
	private By finishButton = By.xpath("//button[.='Finish']");
	private By completionMessage = By.xpath("//div[.='Succesfully Added!']");
	private By goToHome = By.xpath("//button[.='Go To Home']");
	private By mandatoryErrorMessage = By.xpath(
			"//div[text()='One or more fields are invalid. Please check the highlighted areas and correct the errors to proceed.']");

	private By skipButton = By.xpath("//div/button[text()='Skip']");
	private By closeToastMsg = By.xpath("//*[local-name()='svg' and  @data-testid='CloseIcon']//*[local-name()='path']");
	private By paymentTrems = By.xpath("//label[.='Payment Terms']/following-sibling::div/input[@type='text']");
	//private By terms = By.xpath("reference_id");

	public static String clientname;
	public static String fname;
	public static String Lname;

	public void Add_Client() {

		sleep(2);
		clickElement(clients);
		try {
			DriverManager.getDriver().findElement(skipButton).click();
			System.out.println("Guiding popup is closed");

		} catch (Exception e) {
			System.out.println("Guiding Popup is not Dsisplayed");
		}
		sleep(0.75);
		clickElement(addClient);

	}

	public void InvalidEmail() {
		sleep(2);
		moveToElement(saveButton);
		sleep(0.75);
		clickElement(saveButton);

		if(verifyElementDisplayed(mandatoryErrorMessage)) {
			printStatement("Without entering any details in the Client page the error message is ", "'"+getWebElement(mandatoryErrorMessage).getText()+"'");
		}else {
			printStatement("Without entering any details in the page the error message is - ", "No Error message is displayed");
		}
	}

	public void Client_Information() {

		sleep(2);
		clientname = DataGenerateUtils.randomFirstName();
		scrollToElementAtTop(clientName);
		sleep(1);
		setText(clientName, clientname); 
		System.out.println("Client Name ="+clientname);
		System.out.println(getTextElement(clientId));
		String addressOne = DataGenerateUtils.randomStreetName();
		System.out.println("New Address - "+addressOne);
		setText(address1, addressOne);
		moveToElement(saveButton);
		//		clickElement(state);
		//		clickElement(alabama);
		//		setText(city, DataGenerateUtils.randomCity());
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());
		sleep(1);
		clickElement(paymentTrems);
		sleep(0.5);
		sendKeys_perform(Keys.ENTER);
		sleep(1);
		clickElement(saveButton);
		sleep(1);

		try {
			if(verifyElementDisplayed(successMessage)) {
				sleep(0.5);
				clickElement(closeToastMsg);
			} 
		}catch (Exception e) {
			if(verifyElementDisplayed(existingClient)) {
				sleep(0.5);
				clickElement(closeToastMsg);
				sleep(0.5);
				scrollToPageTop();
				sleep(1);
				KeyBoardPress_ClearField(clientName);
				sleep(0.5);
				setText(clientName, clientname); 
				sleep(1);
				moveToElement(saveButton);
				sleep(0.5);
				clickElement(saveButton);
			}
		}
		sleep(3);
	}

	public void Client_Contact_Information() {
		sleep(1);
		moveToElement(firstName);
		scrollToPageTop();
		sleep(1);
		fname = DataGenerateUtils.randomFirstName();
		Lname=DataGenerateUtils.randomLastName();
		setText(firstName, fname); 
		setText(lastName, Lname);
		setText(email, DataGenerateUtils.randomEmail());
		setText(phoneNumber, DataGenerateUtils.randomPhoneNumber());
		moveToElement(finishButton);
		sleep(3);
		clickElement(finishButton);
	}

	public void Client_Onboard_Completion() {
		sleep(1);
		verifyElementVisible(completionMessage);
		clickElement(goToHome);
	}



}



