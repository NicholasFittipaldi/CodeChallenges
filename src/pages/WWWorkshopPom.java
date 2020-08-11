package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WWWorkshopPom {
	WebDriver driver;
	
	By workshopTitle = By.className("locationName-1jro_");
	
	public WWWorkshopPom(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyTitle(String name) {
		String title = driver.findElement(workshopTitle).getText();		
		Assert.assertTrue(title.equals(name));
	}
}
