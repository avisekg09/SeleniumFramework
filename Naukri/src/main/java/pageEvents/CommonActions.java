package pageEvents;

import java.util.List;

import org.openqa.selenium.WebElement;

import pageObjects.SearchedJobPageObj;
import utils.FetchElement;

public class CommonActions{

	FetchElement ele = new FetchElement();
	int counter = 0;
	public void SelectDropdown(String dropdownValue, WebElement dropdownElement) {
		dropdownElement.click();
//		JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
//		js.executeScript("arguments[0].click();", dropdownElement);
	}
	
	public void moveToNextPage() {
		
		
	}
}
