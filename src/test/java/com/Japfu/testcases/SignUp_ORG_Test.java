package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class SignUp_ORG_Test extends BaseTest {

	@Test(priority = 1)
	public void SC_Verify_Email_And_Password_Creation_Of_New_User() {
		getsignUpPage().Launch_Url();
		getsignUpPage().Yopmail_Verification();
		getsignUpPage().Create_New_Password();
	}

	@Test(priority = 2)
	public void SC_Verify_Organization_Configuration_With_Invalid_Data() {
		getsignUpPage().organization_Config_WithInvalidData();
	}

	@Test(priority = 3)
	public void SC_Verify_Organization_Configuration_With_Valid_Data() {
		getsignUpPage().Login_In_To_New_SignUp_User();
		getLogout_page().Logout();
	}


}
