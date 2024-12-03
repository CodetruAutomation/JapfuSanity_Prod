package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class Admin_SubmitNewTimesheet_Test extends BaseTest {

	@Test(priority = 1)
	public void SC_Verify_Adding_a_Timesheet_For_an_Employee() {
		adminTimesheet().OpenTimesheetPage();
		adminTimesheet().navigate_to_addNewTimesheet();
		adminTimesheet().add_New_Future_Timesheet();
		getLogout_page().Logout();
	}
	
	





}