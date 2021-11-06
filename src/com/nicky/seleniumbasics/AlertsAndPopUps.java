package com.nicky.seleniumbasics;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndPopUps {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		WebDriver wd = new ChromeDriver();
		wd.get("http://the-internet.herokuapp.com/javascript_alerts");
		/*****
		 * JS ALERT
		 */
		// click on alert button
		wd.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();

		// switch to alert
		Alert jsAlert = wd.switchTo().alert();

		// grab text
		String alertText = jsAlert.getText();

		System.out.println("The alert text is ----------- \n" + alertText);

		// click okay btn
		jsAlert.accept();

		// validate text on page after accepting alert
		assertEquals(wd.findElement(By.id("result")).getText(), "You successfully clicked an alert");

		/*************************
		 * JS CONFIRM
		 */

		// click on confirmation button
		wd.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]")).click();

		// switch to confirmation pop up
		Alert jsConfirm = wd.switchTo().alert();

		// get text from confirmation box
		System.out.println("The text on confirmation pop up is --------------------------\n" + jsConfirm.getText());

		// click ok
		jsConfirm.accept();
		// validate text
		assertEquals(wd.findElement(By.id("result")).getText(), "You clicked: Ok");

		/*********************************************************
		 * clicking on cancel button
		 * 
		 */

		// click on confirmation button
		wd.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();

		// switch to the confirmation pop up
		Alert jsConfirmation = wd.switchTo().alert();

		// get the text from confirmation box
		System.out.println("The text on Confirmation pop up is  --- " + jsConfirmation.getText());

		// click on Cancel button
		jsConfirmation.dismiss();

		// validate the text on the web page after accepting alert
		assertEquals(wd.findElement(By.id("result")).getText(), "You clicked: Cancel");

		/******************************************************
		 * JS Prompt
		 */
		// click on button for js prompt
		wd.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();

		// switch to the confirmation pop up
		Alert jsPrompt = wd.switchTo().alert();

		// get the text from confirmation box
		System.out.println("The text on prompt pop up is  --- " + jsPrompt.getText());

		// entering text into text box
		jsPrompt.sendKeys("Hello");

		// click on Cancel button
		jsPrompt.accept();

		// validate the text on the web page after accepting alert
		assertEquals(wd.findElement(By.id("result")).getText(), "You entered: Hello");

		/****************************
		 * JS prompt with cancel
		 */
		// click on button for js prompt
		wd.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();

		// switch to the confirmation pop up
		Alert prompt = wd.switchTo().alert();

		// get the text from confirmation box
		System.out.println("The text on prompt pop up is  --- " + prompt.getText());

		// entering text into text box
		prompt.sendKeys("Hello");

		// click on Cancel button
		prompt.dismiss();

		// validate the text on the web page after accepting alert
		assertEquals(wd.findElement(By.id("result")).getText(), "You entered: null");

		wd.close();
		wd.quit();

	}
}
