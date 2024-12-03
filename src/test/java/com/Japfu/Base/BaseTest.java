package com.Japfu.Base;

import com.Japfu.common.CommonPageCICA;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.driver.DriverManager;
import com.Japfu.driver.TargetFactory;
import com.Japfu.helpers.PropertiesHelpers;
import com.codetru.listeners.TestListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends CommonPageCICA {

  // @Parameters("browser")
    @BeforeTest
    public void createDriver() {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(FrameworkConstants.BROWSER));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

//    @AfterTest(alwaysRun = true)
//    public void closeDriver() {
//        DriverManager.quit();
//    }

    public WebDriver createBrowser() {
        PropertiesHelpers.loadAllFiles();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(FrameworkConstants.BROWSER));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }

}