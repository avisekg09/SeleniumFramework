package pageEvents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.SearchedJobPageObj;
import utils.FetchElement;

public class SearchedJobEvents {

	FetchElement ele = new FetchElement();
	CommonActions ca = new CommonActions();
	public List<WebElement> listOfCompanyJob() {
		return ele.getWebElements("XPATH", SearchedJobPageObj.companySearchedResults);
	}
	public List<WebElement> listOfJobTitle() {
		return ele.getWebElements("XPATH", SearchedJobPageObj.jobTitle);
	}
	public List<WebElement> listOfJobExp() {
		return ele.getWebElements("XPATH", SearchedJobPageObj.jobExperience);
	}
	public WebElement changePage() {
		 return ele.getWebElement("XPATH", SearchedJobPageObj.pagination);
	}
	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
		wait.until(ExpectedConditions.visibilityOfAllElements(logo()));
	}
	public List<WebElement> pages() {
		return ele.getWebElements("XPATH", SearchedJobPageObj.pages);
	}
	public List <WebElement> logo() {
		return ele.getWebElements("XPATH", SearchedJobPageObj.logo);
	}
	public boolean disabledNextButton() {
		// ele.getWebElements("XPATH", SearchedJobPageObj.disableButton);
		try {
	        List<WebElement> elements = ele.getWebElements("XPATH", SearchedJobPageObj.disableButton);
	        return !elements.isEmpty();
	    } catch (Exception e) {
	        return false;
	    }
		
	}
}
