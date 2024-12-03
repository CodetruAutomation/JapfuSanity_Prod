package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class AI_ApproveTimesheet_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Timesheet_Status_Is_Updated_To_Approved_After_Approving() throws Exception {
		getStep_3Page().openTimesheetsPage();
		getStep_3Page().approval_AI_Timesheet();
		getLogout_page().Logout();
	}

}