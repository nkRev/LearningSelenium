package com.nicky.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String[] args) throws InterruptedException {
		// System path for browser driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		WebDriver wd = new ChromeDriver();

		// get instance of browser
		wd.get("http://zero.webappsecurity.com/");

//		// by id.
//		wd.findElement(By.id("searchTerm")).sendKeys("transfer funds");
//
//		// by name
//		wd.findElement(By.name("searchTerm")).clear();
//		wd.findElement(By.name("searchTerm")).sendKeys("Feedback");
//
//
//		// by class name
//		WebElement searchbox = wd.findElement(By.className("search-query"));
//		searchbox.clear();
//
//		searchbox.sendKeys("Account Activity");
//
//
//		// by link text
//		wd.findElement(By.linkText("Zero Bank")).click();
//
//
////		wd.findElement(By.linkText("https://www.microfocus.com/about/legal/#privacy")).click();
////		Thread.sleep(2000);
//
//		//by partial link text
//		wd.findElement(By.partialLinkText("Zero")).click();
//		
//		//by tagname, used only if tagname is unique;
//		wd.findElement(By.tagName("input")).sendKeys("data");

//		wd.findElement(By.partialLinkText("about/legal/#privacy")).click();
//		Thread.sleep(2000);

//		//by CSS
//		//by css selector so id == #id
//		wd.findElement(By.cssSelector("#searchTerm")).clear();
//		wd.findElement(By.cssSelector("#searchTerm")).sendKeys("online banking");
//		
//		//css classname so classname = .classname
//		wd.findElement(By.cssSelector(".search-query")).clear();
//		
//		
//		//css attribute = [attribute = value]
//		wd.findElement(By.cssSelector("[placeholder='Search']")).sendKeys("Zero");
//		
//		//css tag
//		wd.findElement(By.cssSelector("input")).clear();
//		
//		//css tag.class[attribute=value]
//		searchbox = wd.findElement(By.cssSelector("input.search-query[type='text'"));
//		searchbox.clear();
//		searchbox.sendKeys("css = tag.class[attribute=value]");

		// by xpath with tag and attribute
		wd.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("online banking");

		// by xpath with * (tag name) + attribute
		wd.findElement(By.xpath("//*[@type='button']")).click();

		// with contains text method
		wd.findElement(By.xpath("//a[contains(text(), 'Forgot')]")).click();

		// quit and close driver
		wd.close();
		wd.quit();

	}
}
