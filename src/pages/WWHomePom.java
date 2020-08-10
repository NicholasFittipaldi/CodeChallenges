package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WWHomePom {
	WebDriver driver;
	
	By findWorkshop = By.xpath("//a[@href='https://www.weightwatchers.com/us/find-a-workshop/']");
	
	public WWHomePom(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickFindWorkshop() {
		driver.findElement(findWorkshop).click();
	}
}
