package base;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class BaseTest {
	public static WebDriver driver;
	@BeforeSuite
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver)
		        .executeScript("return document.readyState").equals("complete"));
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterSuite
	public void closeBrowser() {
		//driver.quit();
	}

}
