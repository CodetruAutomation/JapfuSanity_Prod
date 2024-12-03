package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.keywords.WebUI;
import com.Japfu.utils.DataGenerateUtils;


public class Employee_Onboard_Consultant_Page extends CommonPageCICA{

	private By Consultant = By.xpath("//li[.='Consultant']");

	private By employee = By.xpath("//img[@alt='employees']/following-sibling::span[.='Employees']");

	private By addEmployee = By.id("add-employee");

	private By onboard = By.xpath("//button[.='Onboard']");

	private By firstName = By.name("first_name");
	private By lastName = By.name("last_name");

	private By gender = By.xpath("//div[@name='gender']//button[@title='Open']");
	private By genderValue = By.xpath("//li[.='Male']");

	private By contactNumber = By.name("contact_number");

	private By emailId = By.name("email_id");

	private By address1 = By.name("address_line_one");

	//private By country = By.xpath("//label[.='Country']/following-sibling::div/input[@role='combobox']");
	//	private By unitedStates = By.xpath("//li[.='United States']");

	//private By state = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	//	private By alabama = By.xpath("//li[.='Alabama']");

	//private By city = By.name("city");
	private By zipcode = By.name("zip_code");

	private By employmentType = By.xpath("//label[.='Employment Type']/following-sibling::div/input[@role='combobox']");


	private By employmentcategory = By.xpath("//label[.='Employment Category']/following-sibling::div/input[@role='combobox']");
	private By w2 = By.xpath("//li[.='W2']");
	private By UpdatedDOB = By.xpath("//input[@placeholder='MM/DD/YYYY']");

	private By joiningCalander = By.xpath("//button[@aria-label='Choose date']//*[local-name()='svg']");
	private By leftArrow = By.xpath("//*[local-name()='svg' and @data-testid='ArrowLeftIcon']");
	private By date1 = By.xpath("//button[text()='1']");
	private By okButton = By.xpath("//button[text()='OK']");

	private By employeeUSC = By.xpath("//label[contains(text(),'Is the Employee')]/following-sibling::div/input[@role='combobox']");
	private By employeeyes = By.xpath("//li[.='Yes']");

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

	private By bankName = By.name("bank_name");
	private By accountType = By.xpath("//label[.='Account Type']/following-sibling::div/input[@role='combobox']");
	private By savings = By.xpath("//li[.='Savings']");
	private By accountNumber = By.name("account_number");
	private By confirmAccountNumber = By.name("confirm_account_number");
	private By routingNumber = By.name("routing_number");
	private By confirmRoutingNumber = By.name("confirm_routing_number");

	private By depositConfiguration = By.xpath("//label[.='Choose Deposit Configuration']/following-sibling::div/input[@role='combobox']");
	private By fullnet = By.xpath("//li[.='Full Net']");

	private By finishButton = By.xpath("//button[.='Finish']");

	private By congratulation = By.xpath("//div[.='Congratulations']");
	private By backTOHome = By.xpath("//button[normalize-space()='Go To Home']");

	//	private By zohoCrossMark = By.xpath("//img[contains(@src,'/static/media/cross-mark')]");

	private By ssn = By.name("ssn");
	private By zipcode2 = By.xpath("(//input[@name='zip_code'])[2]");
	private By mainPageErrorMessage = By.xpath(
			"//div[text()='One or more fields are invalid. Please check the highlighted areas and correct the errors to proceed.']");

	private By closeToastMessage = By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']//*[local-name()='path']");


	public static String fname ;
	public static String lname ;
	public static String email ;
	public static String pass = "Codetru@007";

	public void verify_Navigating_to_Homepage_Once_click_on_Login(){

		if(!verifyElementVisible(logo)) {
			System.out.println("Unable to Navigate to Homepage");
		}else if(verifyElementVisible(logo)) {
			System.out.println("Navigated to Homepage");
		}
	}

	public void EmployeeInvalidInformation() {

		clickElement(employee);
		sleep(1);
		clickElement(addEmployee);
		sleep(1);
		clickElement(onboard);
		sleep(1);


	}

	public void Employee_Information() throws Exception  {


		moveToElement(firstName);
		fname =  DataGenerateUtils.randomFirstName();
		lname =  DataGenerateUtils.randomLastName();
		sleep(1);
		setText(firstName, fname);

		sleep(0.5);
		setText(lastName, lname);
		sleep(1.5);
		
		try {
			DriverManager.getDriver().findElement(joiningCalander).isDisplayed();
			clickElement(joiningCalander);
			sleep(1);
			
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(date1);
        }
		catch(Exception e) {

		clickElement(UpdatedDOB);
		sleep(2);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(date1);
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
		//sleep(1.5);
		clickElement(gender);
		sleep(0.5);
		clickElement(genderValue);
		sleep(1);
		scrollToElementAtBottom(saveButton);
		clickElement(saveButton);

		//Contact details
		clickElement(saveButton);
		sleep(1);
		setText(contactNumber, DataGenerateUtils.randomPhoneNumber());
		sleep(0.5);

		email =  DataGenerateUtils.randomEmail();

		clearAndFillText(emailId, email);
		System.out.println("First Name ="+fname);
		System.out.println("Last Name ="+lname);
		System.out.println("Email ="+email);
		System.out.println("Password ="+pass);
		sleep(1);
		scrollToElementAtBottom(saveButton);
		clickElement(saveButton);
		sleep(2);

		String Add = DataGenerateUtils.randomStreetName();

		//Current Address
		setText(address1, Add);
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());	
		sleep(1);
	
		WebUI.scrollToElementAtBottom(saveButton);
		clickElement(saveButton);

		sleep(1);
		clickElement(employmentType);
		clickElement(Consultant);
		sleep(1);
		clickElement(employmentcategory);
		clickElement(w2);

		try {
			DriverManager.getDriver().findElement(joiningCalander).isDisplayed();
			clickElement(joiningCalander);
			sleep(1);
			
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(leftArrow);
			sleep(0.5);
			clickElement(date1);
        }
		catch(Exception e) {

		clickElement(UpdatedDOB);
		sleep(2);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(leftArrow);
		sleep(0.5);
		clickElement(date1);
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
		sleep(1);
		
		
		WebUI.scrollToElementAtBottom(saveButton);
		clickElement(saveButton);
		sleep(1);

		setText(emergencyContact1Name, DataGenerateUtils.randomMiddleName());
		setText(emergencyContact1Mobile, DataGenerateUtils.randomPhoneNumber());
		clickElement(emergencyContact1Relation);
		clickElement(emergencyContact1Father);
		setText(emergencyContact1Address1, Add);
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());

		moveToElement(emergencyContact2Address1);

		setText(emergencyContact2Name, DataGenerateUtils.randomFirstName());
		setText(emergencyContact2Mobile, DataGenerateUtils.randomPhoneNumber());
		clickElement(emergencyContact2Relation);
		clickElement(emergencyContact2Brother);
		setText(emergencyContact2Address1, Add);

		sleep(0.5);
		setText(zipcode2, DataGenerateUtils.pickRandomZipcodefromList_US());
		sleep(1);
		moveToElement(saveButton);
		sleep(1);
		clickElement(saveButton);
		sleep(1);
		clickElement(closeToastMessage);

		sleep(2);
		isElementVisible(workAuthorization, 20);
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
		sleep(1);
		fileInput.sendKeys(filePath);

		sleep(1);

		String filePath1 = System.getProperty("user.dir")+"//src//test//resources//testdataCMS//W4 form.jpg";
		WebElement fileInput1 = DriverManager.getDriver().findElement(By.xpath("(//input[@type='file'])[2]"));
		sleep(1);
		fileInput1.sendKeys(filePath1);
		sleep(1);
		setText(bankName, "Citizens Bank");
		clickElement(accountType);
		clickElement(savings);
		sleep(0.5);

		clickElement(finishButton);
		sleep(0.5);
		setText(accountNumber, "4099999992");
		setText(confirmAccountNumber, "4099999992");

		setText(routingNumber, "011075150");
		setText(confirmRoutingNumber, "011075150 ");

		clickElement(depositConfiguration);
		clickElement(fullnet);
		sleep(0.5);
		scrollToElementAtBottom(finishButton);
		sleep(0.5);

		clickElement(finishButton);

		sleep(2);

		verifyElementVisible(congratulation);
		clickElement(backTOHome);
		sleep(2);



	}



}


