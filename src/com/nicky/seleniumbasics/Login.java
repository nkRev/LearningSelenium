package com.nicky.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		// System path for browser driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		WebDriver wd = new ChromeDriver();

		// open browser
		wd.get("http://zero.webappsecurity.com/");

		// click on signin button
		wd.findElement(By.id("signin_button")).click();

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
		
		

		// click logout button
		wd.findElement(By.id("logout_link")).click();
		// close browser
		wd.close();

	}
}
