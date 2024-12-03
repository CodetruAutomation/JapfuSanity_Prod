package com.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.Base.BaseTest;


public class Mivi_Test extends BaseTest {


	@Test(priority = 1)
	public void SC_Verify_Interaction_With_The_MIVI_Chatbot() {
		getStep_8Page().Mivi_Chatbox_interaction();
		
	}
	
	@Test(priority = 2)
	public void SC_Verify_MIVI_Chatbot_Interaction_With_Unrecognized_Command() {
		getStep_8Page().Unrecognized_Command();
		getLogout_page().Logout();
	}
	
}
