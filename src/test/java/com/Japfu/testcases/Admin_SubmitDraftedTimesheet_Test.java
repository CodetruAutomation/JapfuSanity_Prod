package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class Admin_SubmitDraftedTimesheet_Test extends BaseTest {


	
	@Test(priority = 1)
	public void SC_Verify_submitting_a_Drafted_Timesheet() {
		adminTimesheet().OpenTimesheetPage();
		adminTimesheet().submit_Timesheet();
		getLogout_page().Logout();
	}

	





}