package demo;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pageObject.GoogleSearchPage;
import pageObject.ResultCountEvaluator;

@ContextConfiguration(classes = TestConfig.class)
public class CucumberTests implements En {


    @Autowired
    private GoogleSearchPage googleSearchPage;

    @Autowired
    private ResultCountEvaluator resultCountEvaluator;


    public CucumberTests() {
        Given("^city name (.*) is typed in search field$", (String cityName) -> {
            googleSearchPage.search(cityName);
        });

        When("^search button is clicked$", () -> {
            googleSearchPage.searchButtonClick();
        });

        Then("^results found should equal (\\d+)$", (Integer resultCount) -> {
            Assert.assertTrue(resultCountEvaluator.areEqual(resultCount, googleSearchPage.getResultsCount()));

        });
    }
}
