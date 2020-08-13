package pages;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WWHomePom {
	WebDriver driver;
	
	By findWorkshop = By.className("Icon_icon__wrapper__3dIsp");
	
	public WWHomePom(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyTitle() throws IOException {
		String url = "https://www.weightwatchers.com/us/";
		Document document = Jsoup.connect(url).get();
		String title = document.title();
		Assert.assertTrue(title.equals("WW (Weight Watchers): Weight Loss & Wellness Help | WW USA"));
	}
	
	public void clickFindWorkshop() {
		driver.findElement(findWorkshop).click();
	}
}
