package com.nicky.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxRadioButtonSelectBox {
	public static void main(String[] args) throws InterruptedException {
		// System path for browser driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		WebDriver wd = new ChromeDriver();

		// get instance of browser
		wd.get("http://zero.webappsecurity.com/");

		// click on signin button
		wd.findElement(By.id("signin_button")).click();

		// enter username
		wd.findElement(By.id("user_login")).sendKeys("username");

		// enter password
		wd.findElement(By.id("user_password")).sendKeys("password");

		// check remember me
		WebElement checkbox = wd.findElement(By.id("user_remember_me"));

		// check if checkbox is displayed
		boolean isDisplayed = checkbox.isDisplayed();

		if (isDisplayed) {
			System.out.println("check box is displayed");

			boolean isEnabled = checkbox.isEnabled();

			// check if checkbox is enabled
			if (isEnabled) {
				System.out.println("check box is enabled");
				boolean isChecked = checkbox.isSelected();

				// check if checkbox is checked
				if (isChecked) {
					System.out.println("Check box is already checked");
				} else {
					checkbox.click();
					System.out.println("check box was not checked, it's checked now");
				}
			}
		}

		wd.findElement(By.name("submit")).click();

		// in case of not secure redirect by chrome
		if (wd.findElement(By.id("details-button")) != null) {
			wd.findElement(By.id("details-button")).click();

			if (wd.findElement(By.id("proceed-link")) != null) {
				wd.findElement(By.id("proceed-link")).click();
			}
		}
		
		/**
		 * Explicit wait
		 * 
		 * 
		 * We can tell the web driver to wait explicitly then tell the webdriver
		 * to find the element again and complete it's next task
		 * ex: 
		 * 	Pay Bills
		 * OR
		 * 
		 * we can specify how long the webdriver should wait then create a web element and use
		 * elementToBeClickable to create a clickable webelement that waits.
		 * 
		 * EX:
		 * 	buying foreign currency
		 */
		
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Pay Bills")));
		
		// navigate to purchase foreign currency
		wd.findElement(By.linkText("Pay Bills")).click();		

//		wd.findElement(By.linkText("Purchase Foreign Currency")).click();

		WebElement buyForeignCurrency = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchase Foreign Currency")));
		buyForeignCurrency.click();
		
		// select box method
		// select currency
		Select currency = new Select(wd.findElement(By.id("pc_currency")));
		currency.selectByVisibleText("Denmark (krone)");
		
		
		// by value
		currency.selectByValue("EUR");
		

		// by index
		currency.selectByIndex(8);
		

		// amt to be purchased
		wd.findElement(By.id("pc_amount")).sendKeys("100");
		

		// working with radio buttons
		wd.findElement(By.id("pc_inDollars_false")).click();
		

		wd.findElement(By.id("purchase_cash")).click();

		wd.close();
		wd.quit();

	}
}
