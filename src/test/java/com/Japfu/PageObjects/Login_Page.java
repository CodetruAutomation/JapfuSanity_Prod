package com.Japfu.PageObjects;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.driver.DriverManager;
import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Login_Page extends CommonPageCICA {

	private By email = By.name("email");
	private By submitBtn = By.xpath("//button[@type='submit']");
	private By passwordBtn = By.xpath("//button[.='Enter Password']");
	private By password = By.name("password");



	public void Valid_Admin_Username_Password(String mail, String pass) {

		sleep(1);
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.CONTROL,"A"));
		DriverManager.getDriver().findElement(email).sendKeys(Keys.chord(Keys.BACK_SPACE));	
		clearAndFillText(email, mail);
		clickElement(submitBtn);
		sleep(1.5);
		clickElement(passwordBtn);
		sleep(1);
		clearAndFillText(password, pass);
		clickElement(submitBtn);
		sleep(1);
		waitForPageLoaded();
		sleep(4);
		
		try {
			 By zohoCrossMark = By.xpath("//img[contains(@src,'/static/media/cross-mark')]");
			DriverManager.getDriver().findElement(zohoCrossMark).click();
			
		} catch (Exception e) {
			System.out.println("Integration popup is not Displayed");
		}

	}

	public void failedCase() {
		clickElement(passwordBtn);
	}
}


