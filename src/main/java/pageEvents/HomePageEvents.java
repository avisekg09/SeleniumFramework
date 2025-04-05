package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.HomePageObjects;
import utils.Constants;
import utils.FetchElement;

public class HomePageEvents{

	
	FetchElement ele = new FetchElement();
	CommonActions ca = new CommonActions();
	
	public WebElement LoginButton() {
		ExplicitWait(HomePageObjects.loginButton);
		return ele.getWebElement("XPATH", HomePageObjects.loginButton);	
	}
	public WebElement skill() throws InterruptedException {
		ExplicitWait(HomePageObjects.jobSearch);
		return ele.getWebElement("XPATH", HomePageObjects.jobSearch);	
	}
	public WebElement exp() throws InterruptedException {
		ExplicitWait(HomePageObjects.experience);
		ele.getWebElement("XPATH", HomePageObjects.experience).click();
		ca.SelectDropdown(Constants.workExe, ele.getWebElement("XPATH", HomePageObjects.workExpInYears));
		return ele.getWebElement("XPATH", HomePageObjects.experience);
	}
	public WebElement location() {
		ExplicitWait(HomePageObjects.location);
		return ele.getWebElement("XPATH", HomePageObjects.location);
	}
	public WebElement searchButton() {
		ExplicitWait(HomePageObjects.searchButton);
		return ele.getWebElement("XPATH", HomePageObjects.searchButton);
	}
	public void ExplicitWait(String identifierName) {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(identifierName)));
	}
}
