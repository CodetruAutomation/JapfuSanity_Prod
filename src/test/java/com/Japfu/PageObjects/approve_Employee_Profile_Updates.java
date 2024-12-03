package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import com.Japfu.driver.DriverManager;


public class approve_Employee_Profile_Updates {
	private By Requested = By.xpath("//div[.='Requested']");

	private By Pending = By.id("//div[.='Pending']"); 

	private By Employee = By.xpath("//div[.='Employee']");

	private By Approve_Button = By.xpath("//button[.='Approve']");

	private By Okay_Button = By.xpath("//button[.='Okay']");

	private By CrossButton = By.xpath("//img[contains(@src , '/static/media/cross-mark-zoho')]");


	public void Approve_Employee_Personal_Details(){

		sleep(2);
		if(verifyElementDisplayed(Requested)) {

			clickElement(Requested);
			sleep(1);

			try {
				DriverManager.getDriver().findElement(CrossButton).click();
				System.out.println("Integration popup is displayed");
			} catch (Exception e) {

				System.out.println("Integration popup is not displayed");
				sleep(1);
				scrollToPageBottom();
				scrollToElementAtBottom(Approve_Button);
				sleep(1);
				clickElement(Approve_Button);
				sleep(1);
				clickElement(Okay_Button);
				sleep(2);
				DriverManager.getDriver().navigate().back();

			}


		}else if(verifyElementDisplayed(Pending)) {

			clickElement(Pending);
			sleep(1);
			clickElement(Employee);
			sleep(1);

			try {
				DriverManager.getDriver().findElement(CrossButton).click();
				System.out.println("Integration popup is displayed");
			} catch (Exception e) {
				System.out.println("Integration popup is not displayed");
				sleep(1);
				clickElement(Requested);
				scrollToPageBottom();
				scrollToElementAtBottom(Approve_Button);
				sleep(1);
				clickElement(Approve_Button);
				sleep(1);
				clickElement(Okay_Button);
				sleep(2);
				DriverManager.getDriver().navigate().back();
			}

		}else {
			System.err.println("No Pending Actions");
		}


	}


}
