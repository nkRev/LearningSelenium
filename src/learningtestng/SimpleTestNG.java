package learningtestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SimpleTestNG {
  @Test(dataProvider = "dp")
  public void DPTest(Integer n, String s) {
	  System.out.println("This is data provider test");
  }
  @Test
  public void test1() {
	  System.out.println("This is test 1");
  }
  @Test
  public void test2() {
	System.out.println("This is test 2");  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("this is after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("this is before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("this is after suite");
  }
@DataProvider
public Object[][] dp(){
	System.out.println("This is the data provider");
	return new Object[][] {
		new Object[] {1, "a"},
		new Object[] {2, "b"},
	};
}
}
