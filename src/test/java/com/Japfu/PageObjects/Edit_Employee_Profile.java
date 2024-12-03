package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;

import com.Japfu.driver.DriverManager;
import com.Japfu.utils.DataGenerateUtils;


public class Edit_Employee_Profile {
	private By My_Profile = By.xpath("//img[@alt='employees']/following-sibling::span[.='My Profile']");

	private By Edit_Icon = By.xpath("//img[@alt='Edit']"); 

	private By Marital = By.xpath("//label[contains(text(),'Marital Status')]/following-sibling::div/input[@role='combobox']");
	private By Marital_status = By.xpath("//li[.='Single']");

	private By Address1 = By.name("address_line_one");
	private By Zipcode  = By.name("zip_code");
	private By genderDescription = By.name("gender_description");

	private By Save_Button = By.xpath("//button[.='Save']");

	private By Changes_Request_message_Alert = By.xpath("//div[.='Do you want to make this changes?']");
	private By Yes_Button = By.xpath("(//button[.='Yes'])[4]");


	private By Changes_Approval_Sent_Alert = By.xpath("//div[.='Changes Sent For Approval']");

	private By Okay_Button = By.xpath("//button[.='Okay']");

	private By add_Error_Msg = By.xpath("//div[text()='Please enter a valid address']");
	private By zipcode_Error_Msg = By.xpath("//div[text()='Invalid Zipcode / Pincode']");
	private By toast_Error_Msg  = By.xpath("//div[text()='One or more fields are invalid. Please check the highlighted areas and correct the errors to proceed.']");
	private By closeBtn = By.xpath("//button[@aria-label='close']");
	//	private By accessDenied = By.xpath("//div[text()='Editing Denied!']");
	//	private By disbaledFieldGender = By.xpath("//input[@value='Male']");
	//	private By discontinuePopup = By.xpath("(//div/div[text()='Do you want to discontinue?'])[last()]");
	//	private By yesButton = By.xpath("(//button[text()='Yes'])[last()]"); 
	private By cancelButton = By.xpath("//button[text()='Cancel']");


	public void Update_Employee_Personal_Details() throws Exception {

		scrollToPageTop();
		sleep(1);
		clickElement(Edit_Icon);
		sleep(1.5);


		try {
			sleep(1);
//			scrollToElementAtBottom(Marital);	
//			sleep(1);
//			clickElement(Marital);
//			clickElement(Marital_status);
//			sleep(1);
			
//			try {
//				setText(genderDescription, "Prefer not to say");
//			} catch (Exception e) {
//
//				System.out.println("Gender Description is not displayed");
//			}

//			if(DriverManager.getDriver().findElement(genderDescription).isDisplayed())
//			{
//				setText(genderDescription, "Prefer not to say");
//			}
//			else
//			{
//				System.out.println("Gender Description is not displayed");
//			}
			sleep(1);
			scrollToElementAtBottom(Address1);	
			clearTextCtrlA(Address1);
			sleep(1);
			String add = DataGenerateUtils.randomAddress();
			setText(Address1, add);
			scrollToElementAtBottom(Save_Button);

			clickElement(Save_Button);
			sleep(1);

			verifyElementVisible(Changes_Request_message_Alert);
			sleep(1);
			clickElement(Yes_Button);
			sleep(2);

			verifyElementVisible(Changes_Approval_Sent_Alert);
			sleep(1);
			clickElement(Okay_Button);
			sleep(2);

			printStatement("Verify User able to edit the Profile update - ", "Request sent for profile update");

		} catch (Exception e) {
			sleep(1);
			clickElement(Okay_Button);
			printStatement("Verify User able to edit the Profile update - ", "Access denied due to Pending Request ");
		}

	}

	public void Update_Employee_Personal_Details_with_Invalid_Data() {
		sleep(1);
		clickElement(My_Profile);
		sleep(1);
		clickElement(Edit_Icon);
		sleep(1);

		try {

			scrollToElementAtBottom(Address1);	
			clearTextCtrlA(Address1);
			sleep(1);
			setText(Address1,"!@#$%^&)(*&^%");
			sleep(0.5);
			verifyElementExists(add_Error_Msg);
			setText(Zipcode,"4321" );
			verifyElementExists(zipcode_Error_Msg);
			sleep(1);
			clickElement(Save_Button);
			sleep(1);
			verifyElementExists(toast_Error_Msg);
			sleep(1);
			clickElement(closeBtn);
			sleep(1);
			clickElement(cancelButton);
			sleep(1);

		} catch (Exception e) {
			clickElement(Okay_Button);
			printStatement("Verify User able to edit the Profile update - ", "Access denied due to Pending Request ");
		}




	}


}


