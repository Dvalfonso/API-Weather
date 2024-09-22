package API_Weather.controllers;

import API_Weather.Services.GeocodingService;
import API_Weather.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather/{city}/{countryCode}")
    public String getWeatherFromCity(@PathVariable String city, @PathVariable String countryCode) {
        return weatherService.getWeatherFromCity(city, countryCode);
    }
}
