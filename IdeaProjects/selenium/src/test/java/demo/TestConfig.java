package demo;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pageObject.GoogleSearchPage;
import pageObject.ResultCountEvaluator;

@Configuration
@PropertySource("classpath:test.properties")
public class TestConfig {

    private RemoteWebDriver driver = new ChromeDriver();

    @Bean
    public GoogleSearchPage  googleSearchPage() { return new GoogleSearchPage(driver);}

    @Value("${range}")
    private int range;

    @Bean
    public ResultCountEvaluator resultCountEvaluator() {
        return new ResultCountEvaluator(range);
    }
}

