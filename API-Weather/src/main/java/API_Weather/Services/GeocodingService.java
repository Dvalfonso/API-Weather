package API_Weather.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

    private static final String API_KEY = "";
    //http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
    private static final String GEOCODING_API_URL = "http://api.openweathermap.org/geo/1.0/direct?q=";

    public String getCoordinates(String cityName, String stateCode, String countryCode) {
        // Construcción de la URL con los parámetros
        String url = UriComponentsBuilder.fromHttpUrl(GEOCODING_API_URL)
                .queryParam("q", cityName + "," + countryCode) // Construye el query con los datos
                .queryParam("limit", 1)
                .queryParam("appid", API_KEY)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
