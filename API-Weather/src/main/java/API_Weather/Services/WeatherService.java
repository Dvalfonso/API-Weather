package API_Weather.Services;

import API_Weather.entities.GeocodingResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    GeocodingService geocodingService;

    private static final String API_KEY = "c18488caf02574af00baec306dbcf5c3";
    private static final String CURRENT_WEATHER_API = "https://api.openweathermap.org/data/2.5/weather?";

    public String getWeatherFromCity(String cityName, String countryCode) {
        String coordinatesJson = geocodingService.getCoordinates(cityName, countryCode);
        return "";
    }

    /*
     * Conect with the API
     */
    private String getWeather(double lat, double lon) {
        //https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
        return "";
    }
}
