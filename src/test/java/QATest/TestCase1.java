package QATest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.SearchedJobEvents;
import utils.WriteListsToExcel2;

public class TestCase1 extends BaseTest{

	@Test
	public void loginNaukri() throws InterruptedException, IOException {
		HomePageEvents hp = new HomePageEvents();
		SearchedJobEvents sj = new SearchedJobEvents();
		WriteListsToExcel2 saveList = new WriteListsToExcel2();
		int j=0;
		hp.skill().sendKeys("Selenium");
		hp.exp();
		hp.location().sendKeys("Kolkata");
		hp.searchButton().click();
		//Thread.sleep(5000);
		sj.waitForPageLoad();
		System.out.println("-------------List-------------");
		//boolean attr = sj.disabledNextButton();
		while(!sj.disabledNextButton())
		{
		List<WebElement> listOfCompanyText = sj.listOfCompanyJob();
		List<WebElement> listOfJobText = sj.listOfJobTitle();
		List<WebElement> listOfJobExpText = sj.listOfJobExp();
		Thread.sleep(5000);
        // Convert the WebElement list to a List of Strings (extracting the text)
        List<String> textList1 = listOfCompanyText.stream()
                                           .map(WebElement::getText)  // Extract the text from each WebElement
                                           .collect(Collectors.toList());
        List<String> textList2 = listOfJobText.stream()
                .map(WebElement::getText)  // Extract the text from each WebElement
                .collect(Collectors.toList());
        
        List<String> textList3 = listOfJobExpText.stream()
                .map(WebElement::getText)  // Extract the text from each WebElement
                .collect(Collectors.toList());
        
		
		saveList.writeExcel(textList1, textList2, textList3);
		Thread.sleep(5000);
		if(sj.changePage().isEnabled()) {
			sj.changePage().click();
		}else {
			break;
		}
		sj.waitForPageLoad();
		listOfCompanyText.clear();
		listOfJobText.clear();
		listOfJobExpText.clear();
		
		textList1.clear();
		textList2.clear();
		textList3.clear();
		Thread.sleep(5000);
		System.out.println(j);
		j++;
		}
		
		
	}
}
