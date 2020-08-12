package pages;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WWFindWorkshopPom {
	WebDriver driver;
	
	By searchBar = By.id("location-search");
	By enter = By.id("location-search-cta");
	By firstResult = By.className("linkUnderline-1_h4g");
	By distance = By.className("distance-OhP63");
		
	public WWFindWorkshopPom(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyTitle() throws IOException {
		String url = "https://www.weightwatchers.com/us/find-a-workshop/";
		Document document = Jsoup.connect(url).get();
		String title = document.title();
		Assert.assertTrue(title.contains("Find WW Studios & Meetings Near You | WW USA"));
	}
	
	public void searchZipCode() {
		driver.findElement(searchBar).sendKeys("10011");
		driver.findElement(enter).click();
	}
	
	public void printFirstResult() {
		String title = driver.findElement(firstResult).getText();
		String location = driver.findElement(distance).getText();
		
		System.out.println("Title: " + title
				+ "\nDistance: " + location);
	}
	
	public void clickFirstResult() {
		driver.findElement(firstResult).click();
	}
}
