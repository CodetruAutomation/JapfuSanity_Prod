package com.Japfu.PageObjects;


import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import static com.Japfu.keywords.WebUI.*;

public class LaunchBrowserPage extends CommonPageCICA {

	public void Launch_Url() {
		openWebsite(FrameworkConstants.URL_CMS_USER);
	//	waitForPageLoaded();
		
	}


}


