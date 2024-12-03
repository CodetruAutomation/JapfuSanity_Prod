package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;

public class LaunchBrowserTest extends BaseTest {

	@Test(priority = 1)
	public void SC_Launch_Japfu_URL() {
		getLoginPage().Launch_Url();
	}


}
