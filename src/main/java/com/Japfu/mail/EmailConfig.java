package com.Japfu.mail;

import static com.Japfu.constants.FrameworkConstants.REPORT_TITLE;

import com.Japfu.constants.FrameworkConstants;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {

    //Remember to create an app password (App Password) for Gmail before sending
    //If you use Hosting's email, it's normal
    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

	public static final String SERVER = "smtp.office365.com";
	public static final String PORT = "587";

	public static final String FROM = "susheel.m@codetru.com";
	public static final String PASSWORD = "Susheel@12";

	  public static final String[] TO = {"fasiuddin@codetru.com"};
	  
//	   public static final String[] TO = {FrameworkConstants.RECIPIENT_EMAIL1,FrameworkConstants.RECIPIENT_EMAIL2, FrameworkConstants.RECIPIENT_EMAIL3,
//			   FrameworkConstants.RECIPIENT_EMAIL4 };
	   
	public static final String SUBJECT = REPORT_TITLE;

}
