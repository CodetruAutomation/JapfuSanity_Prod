package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class Admin_RejectTimesheet_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Rejecting_a_Submitted_Timesheet() {
		adminTimesheet().OpenTimesheetPage();
		adminTimesheet().rejet_Timesheet();
		getLogout_page().Logout();
	}





}