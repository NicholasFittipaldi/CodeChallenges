package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WWWorkshopPom {
	WebDriver driver;
	
	By workshopTitle = By.className("locationName-1jro_");
	By scheduleTitle = By.className("title-bEfSM");
	By schedule = By.className("scheduleContainerMobile-1RfmF");
	
	ArrayList<String> array = new ArrayList<String>(Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"));
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public WWWorkshopPom(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyTitle(String name) {
		String title = driver.findElement(workshopTitle).getText();		
		Assert.assertTrue(title.equals(name));
	}
	
	public void printTodaysMeetings(String dayOfWeek) {
		String weekTitle = driver.findElement(scheduleTitle).getText();
		String[] week = driver.findElements(schedule).get(0).getText().split("\n");
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(week));
		
		System.out.println("\n" + weekTitle + " for " + dayOfWeek + ":");
		
		for (String s : arrayList) {			
			if (s.equals(dayOfWeek)) {
				for (int i = arrayList.indexOf(s) + 1; ; i++) {
					if (array.contains(arrayList.get(i)))
						break;
					else if (arrayList.get(i).matches("(.)*(\\d)(.)*"))
						System.out.println(arrayList.get(i));
					else {
						System.out.println(arrayList.get(i) + "\n");
						
						if (map.isEmpty() || !map.containsKey(arrayList.get(i)))
							map.put(arrayList.get(i), 1);
						else
							map.put(arrayList.get(i), map.get(arrayList.get(i)) + 1);
					}
				}
			}
		}
		
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}
}
