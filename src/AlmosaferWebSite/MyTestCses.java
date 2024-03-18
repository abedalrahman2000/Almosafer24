package AlmosaferWebSite;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCses extends Parameters {

	@BeforeTest
	public void MySetup () {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement poUpScreen = driver.findElement(By.className("sc-iBmynh"));
		if (poUpScreen.isDisplayed()) {
			WebElement SARButton = driver.findElement(By.className("cta__saudi"));
			SARButton.click();
		}
		
	}
	
	@Test (priority = 1)
	public void CheckTheDefultLanaguage () {
		String ExpectedLanaguage = "EN";
		String ActualLanaguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		assertEquals(ActualLanaguage, ExpectedLanaguage);
	}
	
	@Test (priority = 2)
	public void CheckTheDefultCurrencyIsSAR () {
		String ExpectedCurrency = "SAR";
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		assertEquals(ActualCurrency, ExpectedCurrency);
		
	}
	
	@Test (priority = 3)
	public void CheckContactNumber () {
		String ExpectedNumber = "+966554400000";
		String ActualNumber = driver.findElement(By.tagName("strong")).getText();
		assertEquals(ActualNumber, ExpectedNumber);
	}
	
	@Test (priority = 4)
	public void QitafLogo (){
		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		assertEquals(TheFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed(), true);
	}
	
	
	@Test (priority = 5)
	public void CheckTheHotelTabIsNotSelected () {
		
		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"), "false");
	}
	
	@Test (priority = 7)
	public void RandomMethodToChangeLanguage () {
		Random rand = new Random();
		int RandomIndexForTheWebSite = rand.nextInt(Websites.length);
		driver.get(Websites[RandomIndexForTheWebSite]);
		
		if (driver.getCurrentUrl().contains("ar")) {
			String ExpextedLang = "ar";
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLang, ExpextedLang);
		}else {
			String ExpectedLang = "en";
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		}
	}
	
	@AfterTest 
	public void ssss () {}
}
