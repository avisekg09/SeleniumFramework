package pageObjects;

import utils.Constants;

public interface HomePageObjects {

	String loginButton = "//a[@title=\"Jobseeker Login\"]";
	String jobSearch = "//input[@placeholder='Enter skills / designations / companies']";
	String experience = "//input[@id='expereinceDD']";
	String location = "//input[@placeholder='Enter location']";
	String searchButton = "//*[@class='qsbSubmit'][text()='Search']";
	String workExpInYears = "//*[@class='dropdownPrimary']//li//*[text()='"+Constants.workExe+"']";
	
	//String workExpInYears = null;
}
