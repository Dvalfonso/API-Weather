package API_Weather.Services;

import API_Weather.entities.GeocodingResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
public class GeocodingService {
//http://localhost:8080/weather/Cordoba/Ar
    private static final String API_KEY = "";
    //http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
    private static final String GEOCODING_API_URL = "http://api.openweathermap.org/geo/1.0/direct?";

    private static final String CURRENT_WEATHER_API = "https://api.openweathermap.org/data/2.5/weather?";

    private String getCoordinates(String cityName, String countryCode) {
        String url = UriComponentsBuilder.fromHttpUrl(GEOCODING_API_URL)
                .queryParam("q", cityName + "," + countryCode)
                .queryParam("limit", 1)
                .queryParam("appid", API_KEY)
                .toUriString();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody().toString();
    }

    public String getWeatherFromCity(String cityName, String countryCode) {
        String jsonString = getCoordinates(cityName, countryCode);
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
        return "";
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
        System.out.println(response.getBody());
        return response.getBody().toString();
    }
}
