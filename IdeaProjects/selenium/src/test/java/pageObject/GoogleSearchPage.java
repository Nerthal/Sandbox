package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends PageObject {

    private String baseUrl = "http://www.google.com";
    @FindBy(id = "lst-ib")
    private WebElement searchBar;

    @FindBy(id = "resultStats")
    private WebElement resultsCount;

    @FindBy(id="_fZl")
    private WebElement searchButton;

    public GoogleSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    public int getResultsCount() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(s -> resultsCount.isDisplayed());
        return Integer.parseInt(this.resultsCount.getText().split("\\(")[0].replaceAll("[^0-9]", ""));
    }

    public GoogleSearchPage search(String searchTerm) {
        driver.get(baseUrl);
        this.searchBar.sendKeys(searchTerm);
        this.searchButton.click();
        return this;
    }

}
