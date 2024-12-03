package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;
import com.Japfu.constants.FrameworkConstants;

public class Approve_Employee_Profile_Updates_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Profile_Update_Is_Pending_Approval() {
		getLogin().Valid_Admin_Username_Password(FrameworkConstants.USERNAME, FrameworkConstants.PASSWORD);
		getEmployee_UpdatesPage().Approve_Employee_Personal_Details();
		getLogout_page().Logout();


	}

}

//use it for QA - "genrocket@myself.fr.nf"
//use it for QA - getLogout_page().Logout2();

//use it for production - FrameworkConstants.USERNAME
//use it for production - getLogout_page().Logout();