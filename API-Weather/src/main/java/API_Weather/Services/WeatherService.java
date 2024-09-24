package API_Weather.Services;


import API_Weather.entities.GeocodingResponse;
import API_Weather.entities.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Service
public class WeatherService {
    @Autowired
    GeocodingService geocodingService;
    @Autowired
    WebClient webClient;

    private static final String API_KEY = "";

    public WeatherResponse getWeatherFromCity(String cityName, String countryCode) {
        GeocodingResponse geocodingResponse = geocodingService.getCoordinates(cityName, countryCode);
        double lat = geocodingResponse.getLat();
        double lon = geocodingResponse.getLon();

        return getWeather(lat, lon);
    }

    private WeatherResponse getWeather(double lat, double lon) {
        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&exclude={part}&appid={API key}
        WeatherResponse weatherResponse = webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/data/2.5/weather")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("appid", API_KEY)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<WeatherResponse>() {})
                .block();

        System.out.println(weatherResponse.getWeather().toString());
        return weatherResponse;
    }
}
