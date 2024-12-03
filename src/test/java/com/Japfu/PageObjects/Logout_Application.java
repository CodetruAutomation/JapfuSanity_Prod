package com.Japfu.PageObjects;

import com.Japfu.common.CommonPageCICA;
import static com.Japfu.keywords.WebUI.*;

import org.openqa.selenium.By;

public class Logout_Application extends CommonPageCICA {
	
	private By profileIcon = By.xpath("//img[contains(@src,'.png') and contains(@class , 'MuiAvatar')]");
	private By logout = By.xpath("(//div[.='Log out'])[2]");
	
	private By profileIcon2 = By.xpath("//div[@id='avatar-click-box']/div/div/img");
	


	public void Logout() {
		sleep(2);
		clickElement(profileIcon);
		sleep(1);
		clickElement(logout);
	}
	
	public void Logout2() {
		sleep(2);
		clickElement(profileIcon2);
		sleep(1);
		clickElement(logout);
	}




}


