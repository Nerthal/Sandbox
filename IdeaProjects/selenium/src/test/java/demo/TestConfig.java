package demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pageObject.ResultCountEvaluator;

@Configuration
@PropertySource("classpath:test.properties")
public class TestConfig {
    @Value("${range}")
    private int range;

    @Bean
    public ResultCountEvaluator resultCountEvaluator() {
        return new ResultCountEvaluator(range);
    }
}

