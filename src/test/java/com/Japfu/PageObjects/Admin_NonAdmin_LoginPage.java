package com.Japfu.PageObjects;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.utils.DataGenerateUtils;
import static com.Japfu.keywords.WebUI.*;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Admin_NonAdmin_LoginPage extends CommonPageCICA {

	private By email = By.name("email");
	private By submitBtn = By.xpath("//button[@type='submit']");
	private By passwordBtn = By.xpath("//button[.='Enter Password']");
	private By password = By.name("password");
	private By ToasterrorMsg = By.xpath("//div[text()='Email Not Registered']");
	private By FielderrorMsg = By.xpath("//div[text()='Please enter a valid Email Id']");
	private By passwordErrorMsg = By.xpath("//div[text()='This field is required']");
	private By myProfile = By.xpath("//span[text()='My Profile']");
	private By non_admin_label = By.xpath("//div[contains(text(),'CON') or contains(text(),'CON')]");
	private By profileBtn = By.xpath("(//img[contains(@class,'MuiAvatar-img')])[2]");
	private By viewProfileBtn = By.xpath("//div[text()='View profile']");
	private By roleText = By.xpath("(//div[contains(@class,'MuiTypography-root')])[3]");
	private By backArrowBtn = By.xpath("//img[@alt='ArrowLeft']");

	public void openLoginPage() {
		openWebsite(FrameworkConstants.URL_CMS_USER);
		waitForPageLoaded();
	}

	public void Launch_Url() {
		openWebsite(FrameworkConstants.URL_CMS_USER);
		waitForPageLoaded();
	}

	public void Valid_Admin_Username_Password(String mail, String pass) {

		sleep(3);
		//		sendKeys_perform(Keys.BACK_SPACE);
		KeyBoardPress_ClearField(email);
		clearAndFillText(email, mail);
		sleep(1);
		clickElement(submitBtn);
		sleep(1);
		clickElement(passwordBtn);
		sleep(1);
		clearAndFillText(password, pass);
		clickElement(submitBtn);
		sleep(1);
		waitForPageLoaded();
		sleep(2);

		try {
			By zohoCrossMark = By.xpath("//img[contains(@src,'/static/media/cross-mark')]");
			DriverManager.getDriver().findElement(zohoCrossMark).click();
		} catch (Exception e) {
			System.out.println("Inetgration popup is not Displayed");
		}

	}

	public void Valid_Non_Admin_Username_Password(String mail, String pass) {

		sleep(1);
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.CONTROL,"A"));
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.BACK_SPACE));	
		clearAndFillText(email, mail);
		sleep(1);
		clickElement(submitBtn);
		sleep(1);
		clickElement(passwordBtn);
		sleep(1);
		clearAndFillText(password, pass);
		clickElement(submitBtn);
		waitForPageLoaded();
		sleep(2);

	}

	public void FailedCase() {
		clickElement(password);
	}

	public void InvalidEmail() {
		sleep(2);
		String Email = DataGenerateUtils.randomEmail();
		clearAndFillText(email, Email);
		sleep(1);
		clickElement(submitBtn);
		sleep(1);
		verifyElementVisible(ToasterrorMsg);
		String emailErrorMsg = getTextElement(ToasterrorMsg);
		printStatement("Toaster Message : ", emailErrorMsg);
		assertEquals(emailErrorMsg, "Email Not Registered");
	}

	public void Field_message_ForInvalid_Email() {
		sleep(2);	  
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.CONTROL,"A"));
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.BACK_SPACE));
		String Email = DataGenerateUtils.randomFirstName();
		clearAndFillText(email, Email);
		clickElement(submitBtn);
		sleep(1);
		verifyElementVisible(FielderrorMsg);
		String feildErrorMsg =  getTextElement(FielderrorMsg);
		printStatement("Field Error Message : ", feildErrorMsg);
		assertEquals(feildErrorMsg,"Please enter a valid Email Id" );

	}

	public void Error_message_for_missing_password(String mail) {
		sleep(2);
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.CONTROL,"A"));
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.BACK_SPACE));	
		clearAndFillText(email, mail);
		sleep(1);
		clickElement(submitBtn);
		sleep(1);
		clickElement(passwordBtn);
		sleep(1);
		clickElement(submitBtn);
		sleep(1);
		verifyElementVisible(passwordErrorMsg);
		String passError = getTextElement(passwordErrorMsg);
		printStatement("Password field Error Message : ", passError);
		assertEquals(passError,"This field is required");
		clickElement(email);

	}

	public void get_Lable_of_Non_Admin() {
		sleep(2);
		clickElement(myProfile);
		sleep(1);
		verifyElementVisible(non_admin_label);
		String employeType = getTextElement(non_admin_label);
		sleep(0.5);
		printStatement("Login Type - ",employeType);
		sleep(2);

	}

	public void get_Lable_of_Admin() {
		sleep(2);
		clickElement(profileBtn);
		sleep(1);
		clickElement(viewProfileBtn);
		sleep(1);
		verifyElementVisible(roleText);
		String employeType = getTextElement(roleText);
		printStatement("Role of the Logged User - ",employeType);
		sleep(0.5);
		clickElement(backArrowBtn);
		sleep(1);

	}


}


