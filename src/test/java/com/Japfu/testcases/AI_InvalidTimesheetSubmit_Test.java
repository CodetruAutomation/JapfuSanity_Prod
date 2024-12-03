package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class AI_InvalidTimesheetSubmit_Test extends BaseTest {
	
	@Test(priority = 1)
	//Invalid Attachment code
	public void SC_Verify_Error_Handling_When_AI_Fails_To_Capture_Timesheet() throws Exception {
		getStep_3Page().openTimesheetsPage();
		getStep_3Page().AI_InvalidTimesheet();
		getLogout_page().Logout();
	}



}