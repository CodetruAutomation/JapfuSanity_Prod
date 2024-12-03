package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.driver.DriverManager;
import com.Japfu.keywords.WebUI;
import com.Japfu.utils.DataGenerateUtils;
import com.Japfu.utils.Reusablemethods;



public class Employee_Onboard_Contractor_Page extends CommonPageCICA{

	private By contractor = By.xpath("//li[.='Contractor']");

	private By employee = By.xpath("//img[@alt='employees']/following-sibling::span[.='Employees']");

	private By addEmployee = By.id("add-employee"); 

	private By onboard = By.xpath("//button[.='Onboard']");

	private By firstName = By.name("first_name");
	private By lastName = By.name("last_name");

	//	private By dOB = By.xpath("//button[@aria-label='Choose date']");
	//	private By dOByear = By.xpath("//button[@aria-label='calendar view is open, switch to year view']");
	//	private By dOByear1998 = By.xpath("//button[.='1998']");
	//	private By dOBDate1 = By.xpath("//button[.='1']");

	//private By dobInput = By.xpath("//div/label[text()='Date of Birth']/following-sibling::div/input");	

	private By gender = By.xpath("//label[.='Gender']/following-sibling::div/input[@role='combobox']");
	private By genderValue = By.xpath("//li[.='Male']");

	//	private By marital = By.xpath("//label[.='Marital Status']/following-sibling::div/input[@role='combobox']");
	//	private By marital_status = By.xpath("//li[.='Single']");

	private By contactNumber = By.name("contact_number");

	private By emailId = By.name("email_id");

	private By address1 = By.name("address_line_one");

	//	private By country = By.xpath("//label[.='Country']/following-sibling::div/input[@role='combobox']");
	//	private By unitedStates = By.xpath("//li[.='United States']");
	//	private By state = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	//	private By alabama = By.xpath("//li[.='Alabama']");
	//	private By city = By.name("city");
	private By zipcode = By.name("zip_code");
	private By zipcode2 = By.xpath("(//input[@name='zip_code'])[2]");

	private By employmentType = By.xpath("//label[.='Employment Type']/following-sibling::div/input[@role='combobox']");
	private By employmentcategory = By.xpath("//label[.='Employment Category']/following-sibling::div/input[@role='combobox']");
	private By w2 = By.xpath("//li[.='W2']");

	//	private By W1099 = By.xpath("//li[.='1099']");
	//	private By Srivari = By.xpath("//li[.='Srivari']");	

	private By vendorType = By.xpath("//label[.='Vendor']/following-sibling::div/input[@role='combobox']");
	//	private By vendor = By.xpath("//li[.='HUL']");
	private By ssn = By.name("ssn");


	private By joiningCalander = By.xpath("//button[@aria-label='Choose date']//*[local-name()='svg']");
	private By leftArrow = By.xpath("//*[local-name()='svg' and @data-testid='ArrowLeftIcon']");
	private By joiningDate1 = By.xpath("//button[.='1']");

	private By employeeUSC = By.xpath("//label[contains(text(),'Is the Employee')]/following-sibling::div/input[@role='combobox']");
	private By employeeyes = By.xpath("//li[.='Yes']");
	//	private By Employee_no = By.xpath("//li[.='No']");

	//	private By Enable_User_Access = By.xpath("//*[local-name()='svg' and @fill='none']//*[name()='rect']");

	private By saveButton = By.xpath("//button[.='Save & Continue']");

	private By logo = By.xpath("//img[@alt='Logo']");

	private By emergencyContact1Name = By.xpath("(//input[@name='name'])[1]");
	private By emergencyContact1Mobile = By.xpath("(//input[@name='contact_number'])[1]");
	private By emergencyContact1Relation = By.xpath("(//label[.='Relation']/following-sibling::div/input[@role='combobox'])[1]");
	private By emergencyContact1Father = By.xpath("//li[.='Father']");
	private By emergencyContact1Address1 = By.xpath("(//label[.='Address Line-1']/following-sibling::div/input)[1]");
	//	private By emergencyContact1Country = By.xpath("(//label[.='Country']/following-sibling::div/input[@role='combobox'])[1]");
	//	private By emergencyContact1State = By.xpath("(//label[.='State']/following-sibling::div/input[@role='combobox'])[1]");
	//	private By emergencyContact1City = By.xpath("(//input[@name='city'])[1]");
	//	private By emergencyContact1Zipcode = By.xpath("(//input[@name='zip_code'])[1]");

	private By emergencyContact2Name = By.xpath("(//input[@name='name'])[2]");
	private By emergencyContact2Mobile = By.xpath("(//input[@name='contact_number'])[2]");
	private By emergencyContact2Relation = By.xpath("(//label[.='Relation']/following-sibling::div/input[@role='combobox'])[2]");
	private By emergencyContact2Brother = By.xpath("//li[.='Brother']");
	private By emergencyContact2Address1 = By.xpath("(//label[.='Address Line-1']/following-sibling::div/input)[2]");
	//	private By emergencyContact2Country = By.xpath("(//label[.='Country']/following-sibling::div/input[@role='combobox'])[2]");
	//	private By emergencyContact2State = By.xpath("(//label[.='State']/following-sibling::div/input[@role='combobox'])[2]");
	//	private By emergencyContact2City = By.xpath("(//input[@name='city'])[2]");
	//	private By emergencyContact2Zipcode = By.xpath("(//input[@name='zip_code'])[2]");

	private By workAuthorization = By.xpath("//div[.='Work Authorization']");
	private By skipButton = By.xpath("//button[.='Skip']");

	private By addEducationDetails = By.xpath("//div[.='Add Education Details']");

	private By personalDocuments = By.xpath("//div[.='Personal Documents']");

	//private By chequeUpload = By.xpath("(//button[.='Upload'])[1]");

	private By bankName = By.name("bank_name");
	private By accountType = By.xpath("//label[.='Account Type']/following-sibling::div/input[@role='combobox']");
	private By savings = By.xpath("//li[.='Savings']");
	private By accountNumber = By.name("account_number");
	private By confirmAccountNumber = By.name("confirm_account_number");
	private By routingNumber = By.name("routing_number");
	private By confirmRoutingNumber = By.name("confirm_routing_number");

	private By depositConfiguration = By.xpath("//label[.='Choose Deposit Configuration']/following-sibling::div/input[@role='combobox']");
	private By fullnet = By.xpath("//li[.='Full Net']");
	private By UpdatedDOB = By.xpath("//input[@placeholder='MM/DD/YYYY']");


	private By finishButton = By.xpath("//button[.='Finish']");

	private By congratulation = By.xpath("//div[.='Congratulations']");
	private By backTOHome = By.xpath("//button[normalize-space()='Go To Home']");
	private By okButton = By.xpath("//button[text()='OK']");

	private By zohoCrossMark = By.xpath("//img[contains(@src,'/static/media/cross-mark')]");

	private By mainPageErrorMessage = By.xpath(
			"//div[text()='One or more fields are invalid. Please check the highlighted areas and correct the errors to proceed.']");
	private By closeToastMessage = By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']//*[local-name()='path']");

	public static String fname ;
	public static String lname ;
	public static String email ;
	public static String pass = "Codetru@007";

	public void verify_Navigating_to_Homepage_Once_click_on_Login() {

		if(!verifyElementVisible(logo)) {
			System.out.println("Unable to Navigate to Homepage");
		}else if(verifyElementVisible(logo)) {
			System.out.println("Navigated to Homepage");
		}
	}

	private By clients = By.xpath("//img[@alt='ledger']");
	private By vendor = By.xpath("//div[.='Vendors']");
	private By addVendor = By.xpath("//img[@alt='plus']");
	private By countOfVendors = By.xpath("//div[text()='Count']");

	public void CheckForVendor() {

		sleep(2);
		clickElement(clients);
		sleep(1);
		clickElement(vendor);
		sleep(1);
		int	count = Reusablemethods.PickNumericsand_int(getTextElement(countOfVendors));
		
		if(count>=1) {
			System.out.println("Vendor Exists");
		}else if(count<1) {
			clickElement(addVendor);
			vendorPage().VendorOnboard_individual();
		}
	}

	public void EmployeeInvalidInformation() {

		clickElement(employee);
		clickElement(addEmployee);
		clickElement(onboard);

		//basic details
		try {
			DriverManager.getDriver().findElement(zohoCrossMark).click();
		} catch (Exception e) {
			System.out.println("Inetgration bar is not Displayed");
		}

		scrollToElementAtBottom(saveButton);
		clickElement(saveButton);
		sleep(1);
		verifyElementDisplayed(mainPageErrorMessage);

	}

	public void Employee_Information() throws Exception {

		//		try {
		//			DriverManager.getDriver().findElement(skipButton).click();
		//			System.out.println("Guiding popup is closed");
		//		} catch (Exception e) {
		//			System.out.println("Guiding popup is not Displayed");
		//		}
		//		clickElement(addEmployee);
		//		sleep(0.5);
		//		clickElement(onboard);
		//
		//		try {
		//			DriverManager.getDriver().findElement(zohoCrossMark).click();
		//			System.out.println("Inetgration bar is closed");
		//		} catch (Exception e) {
		//			System.out.println("Integration bar is not Displayed");
		//		}
		//		
		//		//basic details 
		//		clickElement(saveButton);
		fname =  DataGenerateUtils.randomFirstName();
		lname =  DataGenerateUtils.randomLastName();
		sleep(1);
		setText(firstName, fname);
		sleep(0.5);
		setText(lastName, lname);
		sleep(0.5);


//		clickElement(dobInput);
//		sleep(1);
//		setText(dobInput, DataGenerateUtils.randomDateOfBirthMMDDYYYY());
//		sleep(0.5);
		try {
			DriverManager.getDriver().findElement(joiningCalander).isDisplayed();
			clickElement(joiningCalander);
			sleep(1);
			
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(joiningDate1);
        }
		catch(Exception e) {

		clickElement(UpdatedDOB);
		sleep(2);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(joiningDate1);
		WebUI.sendKeys_perform(Keys.ENTER);
		sleep(2);
		String datevalue = getAttributeElement(UpdatedDOB, "value");
		System.out.println("Date of Birth = "+datevalue);
		sleep(1.5);
		try {
		clickElement(okButton);
		}
		
		catch(Exception ex)
		{
			System.out.println("*******No Ok button Pop up came***********");

		}
		}
		clickElement(gender);
		sleep(0.5);

		clickElement(genderValue);
		sleep(1);
		WebUI.scrollToElementAtBottom(saveButton);
		clickElement(saveButton);

		//Contact details
		clickElement(saveButton);
		sleep(1);
		setText(contactNumber, DataGenerateUtils.randomPhoneNumber());
		sleep(1);
		email =  DataGenerateUtils.randomEmail();
		sleep(0.5);
		clearAndFillText(emailId, email);
		System.out.println("First Name ="+fname);
		System.out.println("Last Name ="+lname);
		System.out.println("Email ="+email);
		System.out.println("Password ="+pass);
		clickElement(saveButton);
		sleep(2);
		clickElement(saveButton);

		//Current Address
		String addressOne = DataGenerateUtils.randomStreetName();
		System.out.println("New Address - "+addressOne);
		setText(address1, addressOne);
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());	
		sleep(1);
		//		clickElement(country);
		//		clickElement(unitedStates);
		//		clickElement(state);
		//		clickElement(alabama);
		//		setText(city,DataGenerateUtils.randomCity());
		//		setText(zipcode, DataGenerateUtils.randomZipCode());
		WebUI.scrollToElementAtBottom(saveButton);
		clickElement(saveButton);

		//Employment details
		sleep(1);
		clickElement(saveButton);
		sleep(1);
		clickElement(employmentType);
		clickElement(contractor);
		sleep(1);
		
		clickElement(employmentcategory);
		clickElement(w2);

		clickElement(vendorType);
		sleep(0.5);
		sendKeys_perform(Keys.ENTER);
		sleep(0.5);
		
		try {
			DriverManager.getDriver().findElement(joiningCalander).isDisplayed();
			clickElement(joiningCalander);
			sleep(1);
			
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(joiningDate1);
        }
		catch(Exception e) {

		clickElement(UpdatedDOB);
		sleep(2);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(joiningDate1);
		WebUI.sendKeys_perform(Keys.ENTER);
		sleep(2);
		String datevalue = getAttributeElement(UpdatedDOB, "value");
		System.out.println("Date of Birth = "+datevalue);
		sleep(1.5);
		try {
		clickElement(okButton);
		}
		
		catch(Exception ex)
		{
			System.out.println("*******No Ok button Pop up came***********");

		}
		}
		//add or remove relation
		clickElement(employeeUSC);
		clickElement(employeeyes);
		sleep(0.5);
		
		setText(ssn, DataGenerateUtils.randomValidSSN());
		sleep(2);
		//clickElement(EnableUserAccess);
		//sleep(1);
		WebUI.scrollToElementAtBottom(saveButton);
		clickElement(saveButton);
		sleep(1);
		
		setText(emergencyContact1Name, DataGenerateUtils.randomMiddleName());
		setText(emergencyContact1Mobile, DataGenerateUtils.randomPhoneNumber());
		clickElement(emergencyContact1Relation);
		clickElement(emergencyContact1Father);
		setText(emergencyContact1Address1, addressOne);
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());
		//		clickElement(emergencyContact1Country);
		//		clickElement(unitedStates);
		//		clickElement(emergencyContact1State);
		//		clickElement(alabama);

		moveToElement(emergencyContact2Address1);

		//setText(emergencyContact1City, DataGenerateUtils.randomCity());
		//setText(emergencyContact1Zipcode, DataGenerateUtils.randomZipCode());

		setText(emergencyContact2Name, DataGenerateUtils.randomFirstName());
		setText(emergencyContact2Mobile, DataGenerateUtils.randomPhoneNumber());
		clickElement(emergencyContact2Relation);
		clickElement(emergencyContact2Brother);
		setText(emergencyContact2Address1, addressOne);
		sleep(1);
		setText(zipcode2, DataGenerateUtils.pickRandomZipcodefromList_US());
		sleep(1);
		moveToElement(saveButton);

		//		clickElement(emergencyContact2Country);
		//		clickElement(unitedStates);
		//		clickElement(emergencyContact2State);
		//		clickElement(alabama);
		//		setText(emergencyContact2City,  DataGenerateUtils.randomCity());
		//		setText(emergencyContact2Zipcode, DataGenerateUtils.randomZipCode());
		sleep(1);
		clickElement(saveButton);
		
		sleep(1);
		try {
			clickElement(closeToastMessage);
		} catch (Exception e) {
			System.out.println("No Toast Message");
		}
		
		sleep(2);
		isElementVisible(workAuthorization, 30);
		sleep(1);
		clickElement(skipButton);

		sleep(2);
		isElementVisible(addEducationDetails, 20);
		sleep(1);
		clickElement(skipButton);

		sleep(2);
		isElementVisible(personalDocuments, 20);
		sleep(1);
		clickElement(skipButton);

		sleep(2);

		String filePath = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//I9 Document.jpg";

		WebElement fileInput = DriverManager.getDriver().findElement(By.xpath("//input[@type='file']"));
		sleep(0.5);
		fileInput.sendKeys(filePath);

		sleep(1);
		String filePath1 = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//W4 form.jpg";

		WebElement fileInput1 = DriverManager.getDriver().findElement(By.xpath("(//input[@type='file'])[2]"));
		sleep(0.5);
		fileInput1.sendKeys(filePath1);


		sleep(1);
		setText(bankName, "Citizens Bank");

		clickElement(accountType);
		clickElement(savings);

		setText(accountNumber, "4099999992 ");
		setText(confirmAccountNumber, "4099999992 ");

		setText(routingNumber, "011075150");
		setText(confirmRoutingNumber, "011075150 ");

		clickElement(depositConfiguration);
		clickElement(fullnet);

		moveToElement(finishButton);
		sleep(0.5);

		clickElement(finishButton);

		sleep(2);

		verifyElementVisible(congratulation);
		clickElement(backTOHome);
		sleep(2);



	}



}



