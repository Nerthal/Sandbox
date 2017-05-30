package demo;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import pageObject.GoogleSearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObject.ResultCountEvaluator;


@TestPropertySource("/test.properties")
//@RunWith(value = Parameterized.class)
public class SimpleClassTest {
    private RemoteWebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Value("${range}")
    private int range;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

//    @Parameterized.Parameter(value = 0)
//    public String cityName;
//
//    @Parameterized.Parameter(value = 1)
//    public int resultCount;
//
//    @Parameterized.Parameter(value = 2)
//    public int resultRange;
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {"szczebrzeszyn", 2040000, 10000},
//                {"Piekary Śląskie", 5200000, 60000},
//                {"Tychy", 17000000, 100000},
//                {"Bytom", 20000000, 500000},
//                {"Katowice", 62000000, 200000}
//        });
//    }

    @Test
    public void numberOfResultsShouldMatch() {
        ResultCountEvaluator evaluator = new ResultCountEvaluator(2040000, range);
        Assert.assertTrue(evaluator.areEqual(googleSearchPage.search("szczebrzeszyn").getResultsCount()));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}