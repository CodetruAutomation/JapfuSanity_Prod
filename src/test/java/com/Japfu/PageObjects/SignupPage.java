package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.DataGenerateUtils;
import com.Japfu.utils.Reusablemethods;


public class SignupPage extends CommonPageCICA{

	private By signUpButton = By.xpath("//span[.='Sign-up']");
	private By firstName = By.name("first_name");
	private By lastName = By.name("last_name");

	private By gender = By.xpath("//label[.='Gender']/following-sibling::div/input[@role='combobox']");
	private By male = By.xpath("//li[.='Male']");

	private By organizationName = By.name("organization_name");
	private By emailId = By.name("email_id");
	private By mobileNumber = By.name("mobile_number");

	private By createPasswordButton = By.xpath("//button[@type='submit']");

	private By createButton = By.xpath("//button[.='Create Account']");

	//private By mail_Err_Msg = By.xpath("//div[text()='This domain is already registered.']");

	private By emailFldYopmail = By.id("login");

	private By japfuMail = By.xpath("//span[.='JAPFU']");

	private By verifyEmail = By.xpath("//table[@align='center']/tbody/tr/td/a[.='Verify Email']");

	private By password = By.name("password");
	private By confirmPassword = By.name("confirmpassword");

	private By continueButton = By.xpath("//button[.='Continue']");

	private By websiteURL = By.name("website_url");

	private By addressLine1 = By.name("address_line_1");

//	private By country = By.xpath("//label[text()='Country']/following-sibling::div/input[@role='combobox']");
//	private By countryName = By.xpath("//li[.='United States']");
//
//	private By state = By.xpath("//label[text()='State']/following-sibling::div/input[@role='combobox']");
//	private By stateName = By.xpath("//li[.='Alabama']");
//
//	private By city = By.name("city");
	private By zipCode = By.name("zip_code");

	private By saveButton = By.xpath("//button[.='Save']");

	private By leftNavigationArrow = By.xpath("//img[@alt='LeftNavigateArrow']");

	private By dashboardMessage = By.xpath("//div[.='The trail is clear, but the journey has yet to begin.']");
	private By emailErrorMessage = By.xpath("//div[text()='Please enter a valid Email Id']");

	//private By upload = By.xpath("//input[@type='file']");
	private By cancelButton= By.xpath("//button[text()='Cancel']");
	private By editIcon = By.xpath("//img[@alt='Edit']");
//	private By cancelButton= By.xpath("//button[text()='Cancel']");
	
	
//	private By errorMessage = By.xpath("//div[contains(text(), 'One or more fields are invalid')]");
	private By skipButton = By.xpath("//div/button[text()='Skip']");
	private By doneButton = By.xpath("//div/button[text()='Done']");

	public static String fname;
	public static String lname;
	public static String pass = "Codetru@007";
	String mailid = null;
	String orgName = null;
	
	public void Launch_Url() {
		openWebsite("https://yopmail.com/");
		waitForPageLoaded();
	}

	
	public void signupPage() {
		
		sleep(2);
		clickElement(signUpButton);
		
	}
	
	public void InvalidEmail() {
		sleep(1);
		setText(emailId, "kushal123!@#$@gmail.com");

		sleep(1);
		if(verifyElementVisible(emailErrorMessage)) {
			DriverManager.getDriver().findElement(emailId).sendKeys(Keys.chord(Keys.CONTROL,"A"));
			DriverManager.getDriver().findElement(emailId).sendKeys(Keys.chord(Keys.BACK_SPACE));
			System.out.println("Invalid Error Message is Displayed");
		}else {
			System.out.println("No Error Message is Displayed");
		}

	}

	public void SignupWithMissingFields() {
		sleep(2);
		moveToElement(createButton);
		clickElement(createButton);
		sleep(1);
		moveToElement(firstName);
		for(int i=1; i<=6; i++) {

			if(DriverManager.getDriver().findElement(By.xpath("(//div[text()='This field is required'])["+i+"]")).isDisplayed()) {
				System.out.println("Erorr message is dislpayed at field no -"+i);
			}else {
				System.err.println("No error message is displayed");
			}
		}
	}

	public void Signup() {

		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "SignupEmail");

		sleep(2);
		fname = DataGenerateUtils.randomFirstName();
		lname=DataGenerateUtils.randomLastName();
		sleep(1);
		setText(firstName, fname); 
		setText(lastName, lname); 
		System.out.println("Name ="+fname+" "+lname);

		clickElement(gender);
		clickElement(male);

		for(int i=1; i<250;i++) {

			DriverManager.getDriver().findElement(organizationName).sendKeys(Keys.chord(Keys.CONTROL,"A"));
			DriverManager.getDriver().findElement(organizationName).sendKeys(Keys.chord(Keys.BACK_SPACE));
			setText(organizationName, excel.getCellData(i, "Organization names"));

			DriverManager.getDriver().findElement(emailId).sendKeys(Keys.chord(Keys.CONTROL,"A"));
			DriverManager.getDriver().findElement(emailId).sendKeys(Keys.chord(Keys.BACK_SPACE));

			setText(emailId, Reusablemethods.OrganizationName(i));
			sleep(1);

			if(getCssValueElement(emailId, "border-color").contains("rgb(255, 0, 0)")) {
				System.err.println("This domain is already registered.");

			}else if(getCssValueElement(emailId, "border-color").contains("rgb(12, 117, 235)")) {
				System.out.println("Entered valid Email");
				orgName = getAttributeElement(organizationName, "value");
				mailid = getAttributeElement(emailId, "value");
				break;
			}
		}
		
		System.out.println(mailid);
		
		ExcelHelpers exc = new ExcelHelpers();
		exc.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "signupLogin");
		exc.setCellData(mailid, 1, "CurrentSignupEmail");

		sleep(1);
		moveToElement(createButton);
		sleep(1);
		setText(mobileNumber, DataGenerateUtils.randomPhoneNumber());
		sleep(1);

		// Send the space bar key to the page
		sendKeys_perform(Keys.TAB);
		sleep(1);
		sendKeys_perform(Keys.SPACE);
		sleep(1);
		clickElement(createButton);

		sleep(3);

	}
	
	public void Yopmail_Verification() {
		try {
//			openNewTab();
//			sleep(1);
//			openWebsite("https://yopmail.com/");
			ExcelHelpers exc = new ExcelHelpers();
			exc.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "signupLogin");
			String currentEmail = exc.getCellData(1, "CurrentSignupEmail");
			System.out.println("Current Email - "+currentEmail);
			sleep(2);
			setText(emailFldYopmail, currentEmail);
			sendKeys_perform(Keys.ENTER);
			sleep(10);
			switchToFrameByIdOrName("ifinbox");
			sleep(1);
			clickElement(japfuMail);
			sleep(1);
			switchToDefaultContent();
			sleep(1);
			switchToFrameByIdOrName("ifmail");
			clickElement(verifyEmail);
			sleep(10);
		} catch (Exception e) {
			System.out.println("Japfu Confirmation Email not received");
		}

	}

	public void Create_New_Password() {
		
		sleep(1);
		switchToWindowOrTabByPosition(1);
		sleep(15);
		setText(password, FrameworkConstants.PASSWORD);
		setText(confirmPassword, FrameworkConstants.PASSWORD);
		sleep(1);
		clickElement(createPasswordButton);
		
	}

	public void organization_Config_WithInvalidData() {
		ExcelHelpers exc = new ExcelHelpers();
		exc.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "signupLogin");
		String currentEmail = exc.getCellData(1, "CurrentSignupEmail");
		System.out.println("Current Email - "+currentEmail);
		sleep(2);
		
		getLoginPage().Valid_Admin_Username_Password(currentEmail, FrameworkConstants.PASSWORD);
		sleep(3);
		clickElement(continueButton);
		sleep(1);
		clickElement(skipButton);
		sleep(0.5);
		clickElement(doneButton);
		sleep(1);
		moveToElement(saveButton);
		sleep(0.5);
		clickElement(saveButton);
		sleep(0.5);
		clickElement(cancelButton);
		sleep(1);	

	}


	public void Login_In_To_New_SignUp_User() {

//        try {
//			DriverManager.getDriver().findElement(skipButton).click();
//			System.out.println("Guiding Popup is closed");
//		} catch (Exception e) {
//			System.out.println("Guding Popup is not displayed");
//		}
		sleep(2);
        clickElement(editIcon);
		sleep(2);
		String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//images.png";
		sleep(0.5);
		WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
		sleep(1);
		fileInput.sendKeys(filePath);
		sleep(1);

		setText(websiteURL, "www."+orgName+".com");
		sleep(0.5);
		moveToElement(saveButton);
		sleep(1);
		setText(addressLine1 , DataGenerateUtils.randomShortAddress());
		sleep(1);
//		clickElement(country);
//		sleep(0.5);
//		clickElement(countryName);
//		sleep(0.5);
//		clickElement(state);
//		sleep(0.5);
//		clickElement(stateName);
//		sleep(0.5);
//		setText(city ,DataGenerateUtils.randomCity());
//		sleep(0.5);
		setText( zipCode,DataGenerateUtils.pickRandomZipcodefromList_US());
		
		sleep(2);
		moveToElement(saveButton);
		sleep(1);
		clickElement(saveButton);
		sleep(1);
		clickElement(leftNavigationArrow);
		sleep(1);
		clickElement(skipButton);

		if(verifyElementVisible(dashboardMessage)) {
			System.out.println("Signup Successful and Navigated to Dashboard");

		}else {
			System.out.println("Signup Uncessfull");
		}


	}




}



