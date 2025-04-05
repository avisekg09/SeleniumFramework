package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class FetchElement {

	public WebElement getWebElement(String identifierType, String identifierName) {
		
		switch(identifierType) {
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierName));
		
		}
		return null;
	}
	
	public List<WebElement> getWebElements(String identifierType, String identifierName) {
		
		switch(identifierType) {
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierName));
		
		}
		return null;
	}

}
