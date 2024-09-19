package API_Weather.entities;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class WeatherResponse {

    private Coord coord;

    private List<Weather> weather;

    private String base;

    private Main main;

    private int visibility;

    private Wind wind;

    private Clouds clouds;

    private Rain rain;

    private Snow snow;

    private long dt;

    private Sys sys;

    private int timezone;

    private int id;

    private String name;

    private int cod;

    // Clases internas
    @Getter
    public static class Coord {
        private double lon;
        private double lat;
    }
    @Getter
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    public static class Main {
        private double temp;
        private double feels_like;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;
        private int sea_level;
        private int grnd_level;

    }

    @Getter
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;
    }

    @Getter
    public static class Clouds {
        private int all;
    }

    @Getter
    public static class Rain {
        private double one_hour;
    }

    @Getter
    public static class Snow {
        private double one_hour;
    }

    @Getter
    public static class Sys {
        private int type;
        private int id;
        private double message;
        private String country;
        private long sunrise;
        private long sunset;
    }
}
