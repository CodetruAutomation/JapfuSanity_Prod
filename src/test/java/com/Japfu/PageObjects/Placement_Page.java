package com.Japfu.PageObjects;

import static com.Japfu.keywords.WebUI.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.keywords.WebUI;
import com.Japfu.utils.DataGenerateUtils;

public class Placement_Page extends CommonPageCICA {

	private By placement = By.xpath("//img[@alt='placement']");

	private By addPlacement = By.id("add-employee");

	private By add = By.xpath("(//button[.='Add'])[1]");

	private By client = By.xpath("//label[.='Client Name']/following-sibling::div/input[@role='combobox']");
	//	private By clientName = By.xpath("//li[.='"+Client_Onboard_Page.clientname+"']");
	//private By testname1 = By.xpath("//li[.='Purdy']");
	private By contact = By.xpath("(//label[.='Contact']/following-sibling::div/input[@role='combobox'])[1]");
	//	private By contactName = By.xpath("//li[.='"+Client_Onboard_Page.fname+" "+Client_Onboard_Page.Lname+"']");
	//private By testname2 = By.xpath("//li[.='Buffy Rutherford']");
	private By billRate = By.name("bill_rate");
	//	private By otBillRate = By.name("ot_bill_rate");

	private By joiningCalander = By.xpath("//button[@aria-label='Choose date']//*[local-name()='svg']");
	private By leftArrow = By.xpath("//*[local-name()='svg' and @data-testid='ArrowLeftIcon']");
	private By date1 = By.xpath("//button[text()='1']");
	private By okButton = By.xpath("//button[text()='OK']");
	private By UpdatedDOB = By.xpath("//input[@placeholder='MM/DD/YYYY']");

	//	private By startDateInput = By.xpath("//input[@placeholder='MM/DD/YYYY']");
	//	private By startDate = By.xpath("//button[@aria-label='Choose date']");
	//	private By date1 = By.xpath("//button[.='1']");

	private By continueButton = By.xpath("//button[contains(text(),'Continue')]");

	private By jobTitle = By.xpath("//label[.='Job Title']/following-sibling::div/input[@role='combobox']");
	private By addjobButton = By.xpath("//button[text()='New Job Title']");
	private By addJobTitle = By.xpath("(//label[.='Job Title']/following-sibling::div/input[@type='text'])[2]");
	private By saveButton = By.xpath("//button[.='Save']");

	private By workLocation = By.xpath("//label[.='Work Location']/following-sibling::div/input[@role='combobox']");
	private By inOffice = By.xpath("//li[text()='In-Office']");

	private By project = By.xpath("//li[.='Project']");

	private By address1= By.name("address_line_one");

	private By state = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	//	private By alabama = By.xpath("//li[.='Alabama']");
	//	private By city = By.name("city");
	private By zipcode = By.name("zip_code");

	private By payType = By.xpath("//label[.='Pay Type']/following-sibling::div/input[@role='combobox']");
	private By salary = By.xpath("//li[.='Hourly']");

	private By valueButton = By.xpath("//button[.='Value']");
	private By payrate= By.name("value");

	private By sameASPayrate = By.xpath("//div[.='Same as Payrate']");

	private By timesheetCycle = By.xpath("//label[.='Timesheet Cycle']/following-sibling::div/input[@role='combobox']");
	private By semiMonthly = By.xpath("//li[.='Weekly']");

	private By finishButton= By.xpath("//button[.='Finish']");

	private By congratulations = By.xpath("//div[.='Congratulations']");

	private By goToHome = By.xpath("//button[.='Go To Home']");

	private By logo = By.xpath("//img[@alt='Logo']");

	//private By leftArrow = By.xpath("//*[local-name()='svg' and @data-testid='ArrowLeftIcon']");

	private By clientsList = By.xpath("//ul[@role='listbox']/li");

	private By existingPlacement = By.xpath("//div[contains(text(),'Placement Already Exists')]");
	private By closeErrorPopup = By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']//*[local-name()='path']");
	private By placementPage2 = By.xpath("//div[text()='Add Placement Supporting Details']");
	//	private By cllientsList = By.xpath("//ul[@role='listbox']");

	public void Add_placement() {
		clickElement(placement);
		clickElement(addPlacement);
	}

	public void Client_Details() {
		clickElement(add);
		sleep(1);
		clickElement(client);
		sleep(1);

		List<WebElement> clientNames = getWebElements(clientsList);
		int totalSize = clientNames.size();

		String[] clientNamesArray = new String[totalSize];
		for (int i = 0; i < totalSize; i++) {
			clientNamesArray[i] = clientNames.get(i).getText();
		}

		sleep(0.5);
		clickElement(client);
		sleep(0.5);

		for (int i =0; i<=totalSize-1; i++) {
			sleep(0.5);
			scrollToPageTop();
			sleep(0.5);
			clickElement(client);
			sleep(0.5);
			String name =  clientNamesArray[i];
			System.out.println(name);
			DriverManager.getDriver().findElement(client).sendKeys(Keys.chord(Keys.CONTROL,"A"));
			DriverManager.getDriver().findElement(client).sendKeys(Keys.chord(Keys.BACK_SPACE));
			sleep(1);
			setText(client, name, Keys.ENTER);
			sleep(1);
			clickElement(contact);
			sleep(0.5);
			sendKeys_perform(Keys.ARROW_DOWN);
			sleep(0.5);
			sendKeys_perform(Keys.ENTER);
			sleep(1);
			moveToElement(continueButton);
			sleep(0.5);
			DriverManager.getDriver().findElement(billRate).sendKeys(Keys.chord(Keys.CONTROL,"A"));
			DriverManager.getDriver().findElement(billRate).sendKeys(Keys.chord(Keys.BACK_SPACE));
			sleep(0.5);
			setText(billRate, "85");
			sleep(0.5);
			System.out.println("Print1");

			//	 if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {

			if(i == 0 && FrameworkConstants.WINDOWS_LOCAL_AND_US.contains("Yes")) {
				System.out.println("Print2");
				try {
					DriverManager.getDriver().findElement(joiningCalander).isDisplayed();
					sleep(0.5);
					clickElement(joiningCalander);
				}
				catch(Exception ex)
				{
				sleep(0.5);
				clickElement(UpdatedDOB);	
				}
				sleep(1);
				clickElement(leftArrow);
				sleep(0.5);
				clickElement(leftArrow);
				sleep(0.5);
				clickElement(date1);
				sleep(0.5);
				String datevalue = getAttributeElement(UpdatedDOB, "value");
				System.out.println("Date of Birth = "+datevalue);
				try {
					DriverManager.getDriver().findElement(okButton).click();
				} catch (Exception e) {
					printStatement("Is ok button 1 Displayed? - ", "NO");
					System.out.println("*******No Ok Button Popup Displayed***********");
				}
			}else if(i == 0 && FrameworkConstants.LINUX_IN.contains("Yes")) {
				sleep(0.5);
				clickElement(UpdatedDOB);
				sleep(1);
				WebUI.sendKeys_perform(Keys.ENTER);
				sleep(2);
				String datevalue = getAttributeElement(UpdatedDOB, "value");
				System.out.println("Date of Birth = "+datevalue);
				sleep(1.5);
				try {
					printStatement("Is ok button 2 Displayed? - ", "YES");
					DriverManager.getDriver().findElement(okButton).click();

				} catch (Exception e) {
					printStatement("Is ok button 2 Displayed? - ", "NO");
					System.out.println("*******No Ok Button Popup Displayed***********");
				}
			}
			//			try {
			//				DriverManager.getDriver().findElement(joiningCalander).isDisplayed();
			//				clickElement(joiningCalander);
			//				sleep(1);
			//				clickElement(leftArrow);
			//				sleep(0.5);
			//				clickElement(leftArrow);
			//				sleep(0.5);
			//				clickElement(date1);
			//				if(DriverManager.getDriver().findElement(okButton).isDisplayed()) {
			//					printStatement("Is ok button 1 Displayed? - ", "YES");
			//					clickElement(okButton);
			//				}
			//				else{
			//					printStatement("Is ok button 1 Displayed? - ", "NO");
			//					System.out.println("*******No Ok Button Popup Displayed***********");
			//				}
			//			}
			//			catch(Exception e) {
			//
			//				clickElement(UpdatedDOB);
			//				WebUI.sendKeys_perform(Keys.ENTER);
			//				sleep(2);
			//				String datevalue = getAttributeElement(UpdatedDOB, "value");
			//				System.out.println("Date of Birth = "+datevalue);
			//				sleep(1.5);
			//
			//				if(!datevalue.isEmpty()) {
			//					printStatement("Is ok button 2 Displayed? - ", "NO");
			//					System.out.println("*******No Ok Button Popup Displayed***********");
			//
			//				} else if(DriverManager.getDriver().findElement(okButton).isDisplayed()) {
			//					printStatement("Is ok button 2 Displayed? - ", "YES");
			//					clickElement(okButton);
			//				}
			//			}
			WebUI.scrollToElementAtBottom(continueButton);
			sleep(0.5);
			clickElement(continueButton);
			sleep(1.5);

			try {
				
				DriverManager.getDriver().findElement(existingPlacement).isDisplayed();
				
				clickElement(closeErrorPopup);

			} catch (Exception e) {
				DriverManager.getDriver().findElement(placementPage2).isDisplayed();
				break;
			}
		}
	}

	public void Placement_Details() {
		sleep(2);
		scrollToPosition(0, -500);
		sleep(1);
		clickElement(jobTitle);
		sleep(1);

		try {
			DriverManager.getDriver().findElement(project).click();
		} catch (Exception e) {
			clickElement(addjobButton);	
			sleep(0.3);
			setText(addJobTitle,"Project");
			sleep(0.3);
			clickElement(saveButton);
			sleep(0.3);
			clickElement(jobTitle);
			sleep(0.3);
			DriverManager.getDriver().findElement(project).click();
		}

		sleep(0.5);
		clickElement(workLocation);
		clickElement(inOffice); 
		String addressOne = DataGenerateUtils.randomStreetName();
		System.out.println("New Address - "+addressOne);
		setText(address1, addressOne);
		moveToElement(state);
		//		clickElement(state);
		//		clickElement(alabama); 
		//		setText(city, DataGenerateUtils.randomCity());
		setText(zipcode, DataGenerateUtils.pickRandomZipcodefromList_US());

		moveToElement(continueButton);
		sleep(1);
		clickElement(continueButton);

	}

	public void Payrate_Configuration() {
		sleep(1);
		clickElement(payType);
		clickElement(salary);
		clickElement(valueButton);

		setText(payrate, "85");
		sleep(1);

		try {
			DriverManager.getDriver().findElement(sameASPayrate).click();
		} catch (Exception e) {
			System.out.println("Same as payrate is not displayed");
		}

		clickElement(continueButton);

	}

	public void Timesheet_Configuration() {
		sleep(1);
		clickElement(timesheetCycle);
		clickElement(semiMonthly);	
		sleep(1);

		moveToElement(finishButton);
		sleep(1);
		clickElement(finishButton);
		sleep(2);
		verifyElementVisible(congratulations);
		sleep(2);
		clickElement(goToHome);
		sleep(2);
		clickElement(logo);
		sleep(2);

	}



}

