package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends PageObject {

    private String baseUrl = "http://www.google.com";
    @FindBy(id = "lst-ib")
    private WebElement searchBar;

    @FindBy(id = "resultStats")
    private WebElement resultsStats;

    private int resultsCount;


    public GoogleSearchPage(RemoteWebDriver driver) {
        super(driver);
        driver.get(baseUrl);
    }


    public int getResultsCount() {
        return resultsCount;
    }

    private int getResultsExactNumber(String resultText) {
        return Integer.parseInt(resultText.split("\\(")[0].replaceAll("[^0-9]", ""));
    }


    public GoogleSearchPage search(String searchTerm) {
        this.searchBar.sendKeys(searchTerm);
        this.searchBar.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(s -> resultsStats.isDisplayed());
        this.resultsCount = getResultsExactNumber(this.resultsStats.getText());
        return this;
    }

}
