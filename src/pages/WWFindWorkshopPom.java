package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WWFindWorkshopPom {
	WebDriver driver;
	
	By searchBar = By.id("location-search");
	By enter = By.id("location-search-cta");
	By firstResult = By.className("linkUnderline-1_h4g");
	By distance = By.className("distance-OhP63");
		
	public WWFindWorkshopPom(WebDriver driver) {
		this.driver = driver;
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
