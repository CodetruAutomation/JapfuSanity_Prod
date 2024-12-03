package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class Client_Onboard_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Adding_A_New_Client_With_Invalid_Email()  {

		getStep_1Page().Add_Client();
		getStep_1Page().InvalidEmail();

	}
	
	@Test(priority = 2)
	public void SC_Verify_Adding_A_New_Client_With_Valid_Details()  {

		getStep_1Page().Client_Information();
		getStep_1Page().Client_Contact_Information();
		getStep_1Page().Client_Onboard_Completion();
		getLogout_page().Logout();
	}
}
