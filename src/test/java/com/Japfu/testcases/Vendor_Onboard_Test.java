package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class Vendor_Onboard_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Adding_A_New_Vendor_With_Valid_Details() {

		vendorPage().Add_Vendor();
		vendorPage().VendorOnboard_individual();

	}

	@Test(priority = 2)
	public void SC_Verify_Adding_A_New_Vendor_With_Missing_Company_Name() {

		vendorPage().Add_Vendor();
		vendorPage().VedorMissingFields();
		getLogout_page().Logout();

	}


}
