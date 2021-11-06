package com.nicky.seleniumbasics;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAndFrames {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/iframe");

		/***
		 * Working with iFrame
		 */

		// located iFrame
		WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));

		// switching to iFrame
		driver.switchTo().frame(iFrame);

		// enter text into iFrame
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("I have found this iFrame!!!!");
		Thread.sleep(2000);

		// switch back to the parent/main window
		driver.switchTo().defaultContent();
		assertEquals(driver.findElement(By.tagName("h3")).getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");

		/************************************************************
		 * 
		 * 
		 * Working with windows
		 * 
		 * 
		 * 
		 */

		driver.get("https://the-internet.herokuapp.com/windows");
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);

		// click on the link to open child window
		driver.findElement(By.linkText("Click Here")).click();

		// store all the handle of existing windows
		Set<String> handles = driver.getWindowHandles();

		System.out.println(handles);

		handles.forEach(h -> {
			System.out.println(h);
			driver.switchTo().window(h);
		});

		assertEquals(driver.getTitle(), "New Window");

		// close browser
		driver.close();
		driver.quit();

	}

}
