package com.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.Base.BaseTest;

public class Placement_Test extends BaseTest {


	@Test(priority = 1)
	public void TC_Employee_Placement() {

		getStep_2Page().Add_placement();
		getStep_2Page().Client_Details();
		getStep_2Page().Placement_Details();
		getStep_2Page().Payrate_Configuration();
		getStep_2Page().Timesheet_Configuration();
		getLogout_page().Logout();

	}

}
