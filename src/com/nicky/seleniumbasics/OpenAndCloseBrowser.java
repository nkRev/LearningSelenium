package com.nicky.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenAndCloseBrowser {

	public static void main(String[] args) {

		// System path for browser driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		WebDriver wd = new ChromeDriver();

		// open browser
		wd.get("http://zero.webappsecurity.com/");

		// close browser
		wd.close();
	}
}
