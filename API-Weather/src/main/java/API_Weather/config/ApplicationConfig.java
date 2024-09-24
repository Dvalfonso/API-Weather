package API_Weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {
    private static final String GEOCODING_API_URL = "http://api.openweathermap.org/geo/1.0/direct?";
    private static final String CURRENT_WEATHER_API = "https://api.openweathermap.org/data/2.5/weather?";

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://api.openweathermap.org").build();
    }
}
