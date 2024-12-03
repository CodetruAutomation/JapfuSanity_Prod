package com.Japfu.common;

import com.Japfu.PageObjects.*;
import com.Japfu.PageObjects.Employee_Onboard_Contractor_Page;


public class CommonPageCICA {

	private Admin_NonAdmin_LoginPage loginCICA;
	private Employee_Onboard_Consultant_Page Consultant;
	private Client_Onboard_Page step_1Page;
	private Placement_Page step_2Page;
	private Employee_Onboard_Contractor_Page Contractor;
	private TimesheetAttacment_Page getEmployee_TimesheetPage;
	private Timesheet_AI_Page step_3Page;
	private SignupPage signUpPage;
	private EndClient_Onboard_Page step_6Page;
	private Mivi_Page step_8Page;
	private	Logout_Application Logout_page;
	private	Login_Page Login;
	private Vendor_Onboard_Page vendorPage;
	private Timesheet_Admin_Page adminTimesheet;
	private approve_Employee_Profile_Updates getEmployee_UpdatesPage;
	private	Edit_Employee_Profile step_9Page;
	
	
	
	public Admin_NonAdmin_LoginPage getLoginPage() {
		if (loginCICA == null) {
			loginCICA = new Admin_NonAdmin_LoginPage();
		}
		return loginCICA;
	}

	public Employee_Onboard_Consultant_Page getConsultant() {
		if (Consultant == null) {
			Consultant = new Employee_Onboard_Consultant_Page();
		}
		return Consultant;
	}

	public Client_Onboard_Page getStep_1Page() {
		if (step_1Page == null) {
			step_1Page = new Client_Onboard_Page();
		}
		return step_1Page;
	}
	
	public Vendor_Onboard_Page vendorPage() {
		if (vendorPage == null) {
			vendorPage = new Vendor_Onboard_Page();
		}
		return vendorPage;
	}

	public Placement_Page getStep_2Page() {
		if (step_2Page == null) {
			step_2Page = new Placement_Page();
		}
		return step_2Page;
	}

	public Employee_Onboard_Contractor_Page getContractor() {
		if (Contractor == null) {
			Contractor = new Employee_Onboard_Contractor_Page();
		}
		return Contractor;
	}

	
	public Timesheet_AI_Page getStep_3Page() {
		if (step_3Page == null) {
			step_3Page = new Timesheet_AI_Page();
		}
		return step_3Page;
	}

	public SignupPage getsignUpPage() {
		if (signUpPage == null) {
			signUpPage = new SignupPage();
		}
		return signUpPage;
	}

	public EndClient_Onboard_Page getStep_6Page() {
		if (step_6Page == null) {
			step_6Page = new EndClient_Onboard_Page();
		}
		return step_6Page;
	}

	public Mivi_Page getStep_8Page() {
		if (step_8Page == null) {
			step_8Page = new Mivi_Page();
		}
		return step_8Page;
	}
	
	public Logout_Application getLogout_page() {
		if (Logout_page == null) {
			Logout_page = new Logout_Application();
		}
		return Logout_page;
	}
	
	public Login_Page getLogin() {
		if (Login == null) {
			Login = new Login_Page();
		}
		return Login;
	}
	
	public Timesheet_Admin_Page adminTimesheet() {
		if (adminTimesheet == null) {
			adminTimesheet = new Timesheet_Admin_Page();
		}
		return adminTimesheet;
	}
	
	public approve_Employee_Profile_Updates getEmployee_UpdatesPage() {
		if(getEmployee_UpdatesPage == null) {
			getEmployee_UpdatesPage = new approve_Employee_Profile_Updates();
		}
		return getEmployee_UpdatesPage;
	}
	
	public Edit_Employee_Profile getStep_9Page() {
		if (step_9Page == null) {
			step_9Page = new Edit_Employee_Profile();
		}
		return step_9Page;
	}
	
	public TimesheetAttacment_Page getEmployee_TimesheetPage() {
		if(getEmployee_TimesheetPage == null) {
			getEmployee_TimesheetPage = new TimesheetAttacment_Page();
			
		}
		return getEmployee_TimesheetPage;
	}

	//  ------------------------------------------------------------------------------------------------------------------

	


}
