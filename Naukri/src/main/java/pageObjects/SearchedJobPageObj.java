package pageObjects;

public interface SearchedJobPageObj {

	String companySearchedResults = "//*[contains(@class,' comp-name mw-25') or contains(@class,' comp-name ')]";
	String jobTitle = "//*[@class=' row1']/h2/a";
	String jobExperience = "//*[contains(@class,'exp-wrap')]//span[text()]";
	String pagination = "//*[contains(@class,'pagination') and @id='lastCompMark']//a/descendant-or-self::*[text()='Next']";
	String pages = "//*[contains(@class,'pagination') and @id='lastCompMark']//a[text()]";
	String logo = "//img[@alt='Naukri Logo']";
	String disableButton = "//a[@disabled]//*[text()='Next']";
}
