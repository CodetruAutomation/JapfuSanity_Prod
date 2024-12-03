package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class Admin_ApproveTimesheet_Test extends BaseTest {



	@Test(priority = 1)

	public void SC_Verify_Approving_a_Submitted_Timesheet() {
		adminTimesheet().OpenTimesheetPage();
		adminTimesheet().approval_Timesheet();
		getLogout_page().Logout();
	}







}