package main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WWFindWorkshopPom;
import pages.WWHomePom;
import pages.WWWorkshopPom;

public class Question_2 {
	static WebDriver driver = new ChromeDriver();
	
	// I created this method to allow the pages to fully
	// load before trying to locate the web elements.
	public static void letPageLoad() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// Creating this date object allows my code to be more dynamic 
		// when getting the meetings schedule for a specific facility.
		Date today = new Date();
		// This object changes the day of the week so that it is abbreviated
		SimpleDateFormat dayOfWeek = new SimpleDateFormat("E");
		String abbreviated = dayOfWeek.format(today).toUpperCase();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		
		letPageLoad();
		WWHomePom wwHomePage = new WWHomePom(driver);
		wwHomePage.verifyTitle();
		wwHomePage.clickFindWorkshop();
		
		letPageLoad();
		WWFindWorkshopPom wwFindWorkshop = new WWFindWorkshopPom(driver);
		wwFindWorkshop.verifyTitle();
		wwFindWorkshop.searchZipCode();
		wwFindWorkshop.printFirstResult();
		String title = driver.findElement(By.className("linkUnderline-1_h4g")).getText();
		wwFindWorkshop.clickFirstResult();
		
		letPageLoad();
		WWWorkshopPom wwWorkshop = new WWWorkshopPom(driver);
		wwWorkshop.verifyTitle(title);
		wwWorkshop.printTodaysMeetings(abbreviated);
		
		driver.quit();
	}
}
