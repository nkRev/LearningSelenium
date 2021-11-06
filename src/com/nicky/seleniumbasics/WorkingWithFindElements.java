package com.nicky.seleniumbasics;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithFindElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		WebDriver wd = new ChromeDriver();

		// get instance of browser
		wd.get("http://zero.webappsecurity.com/");

		// confirm that you are on the correct page
		assertEquals(wd.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");

		/***********************************************
		 * 
		 * 
		 * Collecting all links from page
		 * 
		 * 
		 */
		// look for all anchor tags and put it in a list of web elements
		List<WebElement> links = wd.findElements(By.tagName("a"));

		System.out.println(links);

		// translate all the links into link text to use the links
		String[] linkTxt = new String[links.size()];
		int i = 0;
//		links.forEach(l -> {
//			linkTxt[i] = l.getText();
//			System.out.println(linkTxt[i]);
//		});
		
		for(WebElement l : links) {
			linkTxt[i] = l.getText();
			System.out.println(linkTxt[i]);
			i++;
		}


		// iterate and click on all the links
		for (String lt : linkTxt) {
			if (lt == "More Services") {
				wd.findElement(By.linkText(lt)).click();
				System.out.println(wd.getTitle());
				wd.navigate().back();
				Thread.sleep(2000);
				assertEquals(wd.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");
			} else if (lt == "<" || lt == ">") {
				continue;
			} else {
				wd.findElement(By.linkText(lt)).click();
				System.out.println(wd.getTitle());
				Thread.sleep(2000);
			}
		}

		wd.close();
		wd.quit();
	}
}
