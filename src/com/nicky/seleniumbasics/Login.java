package com.nicky.seleniumbasics;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Login {
	public static void main(String[] args) {
		// System path for browser driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		WebDriver wd = new ChromeDriver();
		
		//implicitly wait for 5 seconds until web driver quits
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// get instance of browser
		wd.get("http://zero.webappsecurity.com/");
		
		
		/**
		 * USING TestNG
		 * 
		 * We are going to assert the title to test TestNG
		 * 
		 */
		
		String actualTitle = wd.getTitle();
		String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
//		assertEquals(actualTitle, expectedTitle);
		
		//assert with message!
		assertEquals(actualTitle, expectedTitle, "title did not match!");
		
		
		// click on signin button
		wd.findElement(By.id("signin_button")).click();

		/**
		 * assertEquals in a try catch
		 * 
		 */
//		try {
//			assertEquals(wd.getTitle(), "Zero - Log in test");
//		}catch(AssertionError e) {
//			System.out.println(e);
//		}
//		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(wd.getTitle(), "Zero - Personal Banking - Loans - Credit Cards", "Login Page - titles DID NOT match!");
		
		// enter username
		wd.findElement(By.id("user_login")).sendKeys("username");
		
		// enter password
		wd.findElement(By.id("user_password")).sendKeys("password");
		
		// click submit/login
		wd.findElement(By.name("submit")).click();

		if (wd.findElement(By.id("details-button")) != null) {
			wd.findElement(By.id("details-button")).click();

			if (wd.findElement(By.id("proceed-link")) != null) {
				wd.findElement(By.id("proceed-link")).click();
			}
		}
		
		//find way to logout
//		if(wd.findElement(( By.className("dropdown-toggle")).click())) {
//			
//		}

		// click logout button
//		wd.findElement(By.id("logout_link")).click();
		
		
		//assert all
		sa.assertAll();
		
		// close browser
		wd.close();
		
		//close instance
		wd.quit();

	}
}
