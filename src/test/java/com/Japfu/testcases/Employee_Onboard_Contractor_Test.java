package com.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.Base.BaseTest;
import com.Japfu.constants.FrameworkConstants;

public class Employee_Onboard_Contractor_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Adding_A_New_Contractor_With_Missing_Mandatory_Fields() throws Exception {

		getLogin().Valid_Admin_Username_Password("nexgen@fhpfhp.fr.nf", FrameworkConstants.PASSWORD);
		getContractor().CheckForVendor();
		getContractor().EmployeeInvalidInformation();

	}


	@Test(priority = 2)
	public void SC_Verify_Adding_A_New_Contractor_With_Valid_Details() throws Exception {

		getContractor().Employee_Information();
		getLogout_page().Logout();

	}

}
