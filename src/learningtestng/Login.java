package learningtestng;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {

	public WebDriver wd;
	
	@BeforeTest
	public void setup() {
		// System path for browser driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nkayy_0ke5yxj\\Desktop\\Revature\\JWA\\browserdrivers\\chromedriver.exe");

		// initialize web driver
		wd = new ChromeDriver();

		// implicitly wait for 5 seconds until web driver quits
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// get instance of browser
		wd.get("http://zero.webappsecurity.com/");

		String actualTitle = wd.getTitle();
		String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
//				assertEquals(actualTitle, expectedTitle);

		// assert with message!
		assertEquals(actualTitle, expectedTitle, "title did not match!");
	}

	@Test
	public void loginTest() {
		// click on sign in button
		wd.findElement(By.id("signin_button")).click();

		SoftAssert sa = new SoftAssert();
		assertEquals(wd.getTitle(), "Zero - Log in",
				"Login Page - titles DID NOT match!");

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
	}
	
	@AfterTest
	public void cleanUp() {
		wd.close();
		wd.quit();
	}

}
