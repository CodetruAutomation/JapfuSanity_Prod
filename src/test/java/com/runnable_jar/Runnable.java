package com.runnable_jar;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class Runnable {
	
	public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<>();
        suites.add("D:\\D_Eclipse_WorkSpace\\JapfuAutomation_DEMO_V2\\src\\test\\resources\\suites\\Consultant_Suite.xml");  // Path to your TestNG XML file
        testng.setTestSuites(suites);
        testng.run();
    }	

}
