package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class AI_NewTimesheetSubmit_Test extends BaseTest {

	@Test(priority = 1)
	public void SC_Verify_Timesheet_Capture_Using_AI() throws Exception {
		getStep_3Page().openTimesheetsPage();
		getStep_3Page().AI_TimesheetsVerification();
		getLogout_page().Logout();
	}
	

}