package com.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.Base.BaseTest;
import com.Japfu.constants.FrameworkConstants;

public class Employee_Onboard_Consultant_Test extends BaseTest {

	
	 @Test(priority = 1)
	 public void SC_Verify_Adding_A_New_Consultant_With_Missing_Mandatory_Fields() throws Exception {
		 getLogin().Valid_Admin_Username_Password("nexgen@fhpfhp.fr.nf", FrameworkConstants.PASSWORD);
		 getConsultant().EmployeeInvalidInformation();
		 
	 }
	 
	
	 @Test(priority = 2)
	 public void SC_Verify_Adding_A_New_Consultant_With_Valid_Details() throws Exception {
		 
		 getConsultant().Employee_Information();
		// getLogout_page().Logout();
		 
	 }
	 
}
