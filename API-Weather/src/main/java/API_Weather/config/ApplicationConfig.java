package API_Weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {
    private static final String GEOCODING_API_URL = "http://api.openweathermap.org/geo/1.0/direct?";

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(GEOCODING_API_URL).build();
    }
}
