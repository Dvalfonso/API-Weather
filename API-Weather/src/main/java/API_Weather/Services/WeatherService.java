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
        String jsonString = geocodingService.getCoordinates(cityName, countryCode);
        System.out.println(jsonString);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<GeocodingResponse> responseList = objectMapper.readValue(jsonString, new TypeReference<List<GeocodingResponse>>() {});
            if (!responseList.isEmpty()) {
                GeocodingResponse response = responseList.get(0);
                double lat = response.getLat();
                double lon = response.getLon();
                return getWeather(lat, lon);
            } else {
                System.out.println("No results found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Errorrrrrrrrr";
    }

    /*
     * Conect with the API
     */
    private String getWeather(double lat, double lon) {
        //https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
        String url = UriComponentsBuilder.fromHttpUrl(CURRENT_WEATHER_API)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", API_KEY)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody().toString();
    }
}
