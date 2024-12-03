package com.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.Base.BaseTest;
import com.Japfu.constants.FrameworkConstants;

public class Edit_Employee_Profile_Test extends BaseTest {

	@Test(priority = 1)
	public void SC_Login_in_to_Empolyee_Credentials() {
		getLoginPage().Valid_Non_Admin_Username_Password(FrameworkConstants.CONSULTANT_USERNAME, FrameworkConstants.CONSULTANT_PASSWORD);
	}
	
	@Test(priority = 2)
	public void SC_Verify_profile_update_with_invalid_data() {
		getStep_9Page().Update_Employee_Personal_Details_with_Invalid_Data();
	}
	
	@Test(priority = 3)
	public void SC_Verify_profile_update_by_employee() throws Exception {
		getStep_9Page().Update_Employee_Personal_Details();
		getLogout_page().Logout();
		
	}

	

}