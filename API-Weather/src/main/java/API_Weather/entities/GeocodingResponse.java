package API_Weather.entities;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties({"local_names", "state"})
@Data
public class GeocodingResponse {
    private String name;
    private Map<String, String> local_names;
    private double lat;
    private double lon;
    private String country;
    private String state;


    @Override
    public String toString() {
        return "GeocodingResponse{" +
                "name='" + name + '\'' +
                ", local_names=" + local_names +
                ", lat=" + lat +
                ", lon=" + lon +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
