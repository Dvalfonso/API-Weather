package API_Weather.controllers;

import API_Weather.Services.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    @Autowired
    GeocodingService geocodingService;

    @GetMapping("/weather/{city}/{countryCode}")
    public String getWeatherFromCity(@PathVariable String city, @PathVariable String countryCode) {
        return geocodingService.getCoordinates(city, countryCode);
    }
}
