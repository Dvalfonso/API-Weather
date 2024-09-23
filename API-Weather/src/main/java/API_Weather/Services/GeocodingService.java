package API_Weather.Services;

import API_Weather.entities.GeocodingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;



@Service
public class GeocodingService {
    @Autowired
    private WebClient webClient;

    //http://localhost:8080/weather/city/countryCode
    private static final String API_KEY = "c18488caf02574af00baec306dbcf5c3";
    //http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}

    public String getCoordinates(String cityName, String countryCode) {
        String geocodingResponse = webClient.get().uri(uriBuilder -> uriBuilder
                .queryParam("q", cityName, "", countryCode) // Asumiendo que necesitas una clave API
                .queryParam("appid", API_KEY) // Parámetros adicionales
                .build()).retrieve().bodyToMono(String.class).block();

        
        System.out.println(geocodingResponse);
        return "";
    }
}

