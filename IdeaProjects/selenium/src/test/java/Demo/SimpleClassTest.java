package Demo;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SimpleClassTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.google.com";
    }

    @Test
    public void StartChrome()
    {
        driver.get(baseUrl);
    }
}