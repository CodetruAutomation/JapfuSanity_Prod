package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;
import com.Japfu.constants.FrameworkConstants;

public class AdminLoginTest extends BaseTest {

	@Test(priority = 1)
	public void SC_Verify_Admin_Login_With_Invalid_Credentials() {
		getLoginPage().InvalidEmail();
		getLoginPage().Field_message_ForInvalid_Email();
	}

	@Test(priority = 2)
	public void SC_Verify_Admin_Login_With_Missing_Password() {
		getLoginPage().Error_message_for_missing_password(FrameworkConstants.USERNAME);

	}

	@Test(priority = 3)
	public void SC_Verify_Admin_Login_With_Valid_Credentials() {
		getLoginPage().Valid_Admin_Username_Password(FrameworkConstants.USERNAME, FrameworkConstants.PASSWORD);
		getLoginPage().get_Lable_of_Admin();
		getLogout_page().Logout();

	}
	
}
