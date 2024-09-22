package API_Weather.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
