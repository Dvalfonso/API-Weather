package API_Weather.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
public class GeocodingService {
//http://localhost:8080/weather/Cordoba/Ar
    private static final String API_KEY = "c18488caf02574af00baec306dbcf5c3";
    //http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
    private static final String GEOCODING_API_URL = "http://api.openweathermap.org/geo/1.0/direct?";

    String getCoordinates(String cityName, String countryCode) {

        String url = UriComponentsBuilder.fromHttpUrl(GEOCODING_API_URL)
                .queryParam("q", cityName + "," + countryCode)
                .queryParam("appid", API_KEY)
                .toUriString();

        System.out.println("Url coordinates: " + url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("HTTP Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders());
        System.out.println("Response Body: " + response.getBody());
        System.out.println("Response Body: " + response.getBody());  // Esto debe mostrar el JSON completo

        return response.getBody().toString();

    }
}
