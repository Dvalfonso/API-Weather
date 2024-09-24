package API_Weather.Services;

import API_Weather.entities.GeocodingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@Service
public class GeocodingService {
    @Autowired
    private WebClient webClient;

    //http://localhost:8080/weather/city/countryCode
    private static final String API_KEY = "";
    //http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}

    public GeocodingResponse getCoordinates(String cityName, String countryCode) {
        List<GeocodingResponse> geocodingResponse = webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/geo/1.0/direct")
                        .queryParam("q", cityName + "," + countryCode)
                        .queryParam("appid", API_KEY)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GeocodingResponse>>() {})
                .block();

        GeocodingResponse firstResponse = geocodingResponse.get(0);
        System.out.println(firstResponse.toString());
        return firstResponse;
    }
}

