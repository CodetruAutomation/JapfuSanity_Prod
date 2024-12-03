package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.Japfu.common.CommonPageCICA;
import com.Japfu.driver.DriverManager;
import com.Japfu.utils.DataGenerateUtils;

public class Vendor_Onboard_Page extends CommonPageCICA{

	//	private By hUL = By.xpath("//div[.='HUL']");

	private By clients = By.xpath("//img[@alt='ledger']");

	private By vendor = By.xpath("//div[.='Vendors']");

	private By addVendor = By.xpath("//img[@alt='plus']");

	private By vendorName = By.xpath("//label[.='Vendor Name']/following-sibling::div/input[@type='text']");
	//private By Client_Id = By.name("reference_id");

	private By address1 = By.name("address_line_one");

	//	private By state = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	//	private By alabama = By.xpath("//li[.='Alabama']");
	//
	//	private By city = By.name("city");

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
	private By closeToastMsg = By.xpath("//*[local-name()='svg' and  @data-testid='CloseIcon']//*[local-name()='path']");
	private By paymentTrems = By.xpath("//label[.='Payment Terms']/following-sibling::div/input[@type='text']");
	private By successMessage = By.xpath("//div[text()='Success']");
	private By existingClient = By.xpath("//div[text()='Vendor name already exist']");

	public static String fname;
	public static String Lname;
	public static String pass = "Codetru@007";

	public void Add_Vendor() {

		clickElement(clients);
		sleep(1);
		clickElement(vendor);
		sleep(1);
		clickElement(addVendor);	

	}

	public void VedorMissingFields() {
		sleep(2);
		moveToElement(saveButton);
		sleep(0.75);
		clickElement(saveButton);

		if(verifyElementDisplayed(mandatoryErrorMessage)) {
			printStatement("Without entering any details in the Client page the error message is ", "'"+getWebElement(mandatoryErrorMessage).getText()+"'");
			sleep(0.75);
			DriverManager.getDriver().navigate().back();
		}else {
			printStatement("Without entering any details in the page the error message is - ", "No Error message is displayed");
		}
	}


	public void VendorOnboard_individual(){
		sleep(2);
		setText(vendorName, "manda"); 
		String addressOne = DataGenerateUtils.randomStreetName();
		System.out.println("New Address - "+addressOne);
		setText(address1, addressOne); 
		//		clickElement(state);
		//		clickElement(alabama);
		//		setText(city, DataGenerateUtils.randomCity());
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());
		sleep(1);
		clickElement(paymentTrems);
		sleep(0.5);
		sendKeys_perform(Keys.ENTER);
		sleep(1);
		moveToElement(saveButton);
		sleep(1);
		clickElement(saveButton);
		sleep(1);

		try {
			if(verifyElementDisplayed(successMessage)) {
				sleep(0.5);
				clickElement(closeToastMsg);
			}

		} catch (Exception e) {
			if(verifyElementDisplayed(existingClient)) {
				sleep(0.5);
				clickElement(closeToastMsg);
				sleep(0.5);
				scrollToPageTop();
				sleep(1);
				KeyBoardPress_ClearField(vendorName);
				sleep(0.5);
				setText(vendorName, DataGenerateUtils.randomFirstName()); 
				sleep(1);
				moveToElement(saveButton);
				sleep(0.5);
				clickElement(saveButton);
			}
		}

		sleep(3);

		moveToElement(firstName);
		scrollToPageTop();
		fname = DataGenerateUtils.randomFirstName();
		Lname=DataGenerateUtils.randomLastName();
		setText(firstName, fname); 
		setText(lastName, Lname);
		setText(email, DataGenerateUtils.randomEmail());
		setText(phoneNumber, DataGenerateUtils.randomPhoneNumber());
		sleep(1);
		moveToElement(finishButton);
		sleep(1);
		clickElement(finishButton);
		sleep(2);

		if(elementDisplayed(completionMessage)) {
			sleep(1);
			clickElement(goToHome);
			System.out.println("Finished Vendor Onboard");
		} else if(elementDisplayed(finishButton)) {
			sleep(1);
			clickElement(finishButton);
		}
	}


}

//public void VendorOnboard(){
//	sleep(2);
//
//	try {
//		if(DriverManager.getDriver().findElement(hUL).isDisplayed()) {
//			System.out.println("Vendor Exists");
//		}else {
//			System.out.println("Vendor does not exist");
//		}
//	} catch (Exception e) {
//		scrollToPageTop();
//		moveToElement(vendorName);
//		sleep(1);
//		setText(vendorName, DataGenerateUtils.randomFirstName()); 
//		String addressOne = DataGenerateUtils.randomStreetName();
//		System.out.println("New Address - "+addressOne);
//		setText(address1, addressOne); 
//		//			clickElement(state);
//		//			clickElement(alabama);
//		//			setText(city, DataGenerateUtils.randomCity());
//		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());
//		sleep(2);
//		moveToElement(saveButton);
//		clickElement(saveButton);
//
//		sleep(3);
//
//		moveToElement(firstName);
//
//		fname = DataGenerateUtils.randomFirstName();
//		Lname=DataGenerateUtils.randomLastName();
//		setText(firstName, fname); 
//		setText(lastName, Lname);
//		setText(email, DataGenerateUtils.randomEmail());
//		setText(phoneNumber, DataGenerateUtils.randomPhoneNumber());
//		moveToElement(finishButton);
//		sleep(1);
//		clickElement(finishButton);
//
//		sleep(1);
//		verifyElementVisible(completionMessage);
//		clickElement(goToHome);
//	}
//}


