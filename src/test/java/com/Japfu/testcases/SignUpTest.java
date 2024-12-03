package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class SignUpTest extends BaseTest {

	@Test(priority = 1)
	public void SC_Verify_User_Registration_With_Missing_Required_Details() {
		getsignUpPage().signupPage();
		getsignUpPage().InvalidEmail();

	}

	@Test(priority = 2)
	public void SC_Verify_User_Registration_With_Invalid_Email_Format() {

		getsignUpPage().SignupWithMissingFields();

	}

	@Test(priority = 3)
	public void SC_Verify_Successful_User_Registration_With_Valid_Details() {

		getsignUpPage().Signup();
	}



}
