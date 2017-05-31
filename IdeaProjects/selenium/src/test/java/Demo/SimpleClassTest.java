package demo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import pageObject.GoogleSearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

import pageObject.ResultCountEvaluator;

@ContextConfiguration(classes = TestConfig.class)
@RunWith(value = Parameterized.class)
public class SimpleClassTest {
    private RemoteWebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Autowired
    private ResultCountEvaluator resultCountEvaluator;

	private TestContextManager testContextManager;

	@Before
    public void setUp() throws Exception {

		this.testContextManager = new TestContextManager(getClass());
		this.testContextManager.prepareTestInstance(this);

		driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Parameterized.Parameter(value = 0)
    public String cityName;

    @Parameterized.Parameter(value = 1)
    public int resultCount;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"szczebrzeszyn", 2040000},
                {"Piekary Śląskie", 5200000},
                {"Tychy", 17000000},
                {"Bytom", 20000000},
                {"Katowice", 62000000}
        });
    }

    @Test
    public void numberOfResultsShouldMatch() {
        Assert.assertTrue(resultCountEvaluator.areEqual(resultCount, googleSearchPage.search("szczebrzeszyn").getResultsCount()));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}