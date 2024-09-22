package API_Weather.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;


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

        WebClient client = WebClient.create();

        // Realizar una solicitud GET a un endpoint
        Mono<String> response = client.get()
                .uri(uriBuilder -> uriBuilder.path(GEOCODING_API_URL)
                        .queryParam("q", cityName, countryCode)
                        .queryParam("appid", API_KEY)
                        .build())
                .retrieve()  // Enviar la solicitud y recuperar la respuesta
                .bodyToMono(String.class);  // Convertir el cuerpo de la respuesta a String

        // Suscribirse al Mono para obtener la respuesta asíncronamente
        response.subscribe(resp -> System.out.println("Response: " + resp));
        return response.toString();
    }
}
