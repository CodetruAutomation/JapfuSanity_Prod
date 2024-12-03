package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class EndClient_Onboard_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Adding_A_New_End_Client_With_Valid_Details()  {
		
		getStep_6Page().Add_EndClient();
		getStep_6Page().End_Client_Information();
		getStep_6Page().End_Client_Contact_Information();
		getStep_6Page().EndClient_Onboard_Completion();

	}

	@Test(priority = 2)
	public void SC_Verify_Adding_A_New_End_Client_With_Missing_Client_Name()  {

		getStep_6Page().Add_EndClient();
		getStep_6Page().InvalidEmail();
		getLogout_page().Logout();

	}


}
