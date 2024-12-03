package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;
import com.Japfu.constants.FrameworkConstants;

public class LoginTest extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Admin_Login_With_Valid_Credentials() {
		getLogin().Valid_Admin_Username_Password(FrameworkConstants.USERNAME, FrameworkConstants.PASSWORD);

	}

//	@Test(priority = 2)
//	public void SC_Failed() {
//		getLogin().failedCase();
//
//	}

}
