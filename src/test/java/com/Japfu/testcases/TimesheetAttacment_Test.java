package com.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.Base.BaseTest;

public class TimesheetAttacment_Test extends BaseTest {

	
	@Test(priority = 1)
	public void SC_Verify_employee_submits_timesheet_with_a_valid_attachment() {
		getEmployee_TimesheetPage().navigate_To_Timesheet_Page();
		//getEmployee_TimesheetPage().navigate_to_addNewTimesheet();
		getEmployee_TimesheetPage().add_Timesheet_With_ValidFile();
	}

	
	
	@Test(priority = 2)
	public void SC_Verify_timesheet_submission_with_invalid_attachment_format() {
		//getEmployee_TimesheetPage().navigate_to_addNewTimesheet();
		getEmployee_TimesheetPage().add_Timesheet_With_invalidFile();
		getLogout_page().Logout();
	}
	
//	@Test(priority = 3)
//	public void The_Testcase_Was_Intentionally_Failed_To_Verify_The_Failure_Reporting_Mechanism() {
//		getLogin().failedCase();
//
//	}

}
