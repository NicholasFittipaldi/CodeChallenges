package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WWHomePom;

public class Question_2 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.weightwatchers.com/us/");
		
		WWHomePom wwHomePage = new WWHomePom(driver);
		wwHomePage.clickFindWorkshop();
		
		driver.quit();
	}
}
