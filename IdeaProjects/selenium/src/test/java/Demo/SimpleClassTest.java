package Demo;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleClassTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        baseUrl = "http://www.google.com";
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void startChrome() {
        driver.get(baseUrl);
    }
}