package com.Japfu.utils;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;

public class Reusablemethods {

	//	public static void main(String[] args) {

	public static String OrganizationName(int rowNumber) {
		
		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "SignupEmail");
		
		String companyName = excel.getCellData(rowNumber, "Organization names");
		String domainName = excel.getCellData(rowNumber, "Domains");
		String mail;
		
		if(companyName.contains(" ")) {
			String[] words = companyName.split(" ");
			mail = words[0].toLowerCase()+domainName;
			System.out.println("Mail ID : " + mail);
		}else {
			mail = companyName.toLowerCase()+domainName;
			System.out.println("Mail ID : " + mail);
		}
		return mail;

	}

	
	public static String PickNumerics(String input) {
        String numbersOnly = input.replaceAll("[^0-9]", "");
        System.out.println("Count: " + numbersOnly);
        return numbersOnly;
    }

	public static int PickNumericsand_int(String input) {
	    String numbersOnly = input.replaceAll("[^0-9]", "");
	    System.out.println("Count: " + numbersOnly);
	    int numericValue = Integer.parseInt(numbersOnly);
	    return numericValue;
	}



}
