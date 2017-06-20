package demo;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObject.GoogleSearchPage;
import pageObject.ResultCountEvaluator;

public class CucumberTests implements En {
    private RemoteWebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private ResultCountEvaluator resultCountEvaluator = new ResultCountEvaluator(30000);


    public CucumberTests() {
        Given("^city name (.*) is typed in search field$", (String cityName) -> {
            driver = new ChromeDriver();
            googleSearchPage = new GoogleSearchPage(driver);
            googleSearchPage.search(cityName);
        });

        When("^search button is clicked$", () -> {
            googleSearchPage.searchButtonClick();
        });

        Then("^results found should equal (\\d+)$", (Integer resultCount) -> {
            Assert.assertTrue(resultCountEvaluator.areEqual(resultCount, googleSearchPage.getResultsCount()));
            driver.close();
        });
    }
}
