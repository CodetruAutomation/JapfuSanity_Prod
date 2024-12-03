package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class AI_RejectTimesheet_Test extends BaseTest {

	
	@Test(priority = 1)
	public void SC_Verify_Timesheet_Status_Is_Updated_To_Rejected_After_Submission() throws Exception {
		getStep_3Page().openTimesheetsPage();
		getStep_3Page().Rejet_AI_Timesheet();
	}
	
	@Test(priority = 2)
	public void SC_Verify_Timesheet_Rejection_With_An_Invalid_Or_Missing_Rejection_Reason() throws Exception {
		getStep_3Page().Reject_AI_Timesheet_Missing_reject_Reason();
		getLogout_page().Logout();
	}

}