package demo;

import pageObject.GoogleSearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SimpleClassTest {
	private RemoteWebDriver driver;
	private GoogleSearchPage googleSearchPage;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		googleSearchPage = new GoogleSearchPage(driver);
	}

	@Test
	public void numberOfResultsShouldMatch() {
		Assert.assertEquals(2040000, googleSearchPage.search("szczebrzeszyn").getResultsCount());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}