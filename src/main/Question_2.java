package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WWFindWorkshopPom;
import pages.WWHomePom;
import pages.WWWorkshopPom;

public class Question_2 {
	static WebDriver driver = new ChromeDriver();
	
	public static void letPageLoad() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.weightwatchers.com/us/");
		
		WWHomePom wwHomePage = new WWHomePom(driver);
		wwHomePage.clickFindWorkshop();
		
		letPageLoad();
		WWFindWorkshopPom wwFindWorkshop = new WWFindWorkshopPom(driver);
		wwFindWorkshop.searchZipCode();
		wwFindWorkshop.printFirstResult();
		String title = driver.findElement(By.className("linkUnderline-1_h4g")).getText();
		wwFindWorkshop.clickFirstResult();
		
		letPageLoad();
		WWWorkshopPom wwWorkshop = new WWWorkshopPom(driver);
		wwWorkshop.verifyTitle(title);
		
		driver.quit();
	}
}
