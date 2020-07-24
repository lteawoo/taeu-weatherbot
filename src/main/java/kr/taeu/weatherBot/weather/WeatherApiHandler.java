package kr.taeu.weatherBot.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import kr.taeu.weatherBot.weather.domain.LocationInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WeatherApiHandler {
  private static final String WEATHER_API_ENDPOINT = "https://api.openweathermap.org/data/2.5/onecall"
      + "?appid=4e5e44ee68d4171deaa0fc2f47faa60b&lang=kr&units=metric";
  private static final String seoulLatitude = "37.566706";
  private static final String seoulLongtitude = "126.978390";
  
  @RequestMapping(value="/test")
  @ResponseBody
  public String test() {
    log.info("format: " + callApi());
    
    return "test";
  }
  
  public LocationInfo callApi() {
    RestTemplate restTemplate = new RestTemplate();
    String endpoint = WEATHER_API_ENDPOINT + "&lat=" + seoulLatitude + "&lon=" + seoulLongtitude;
    LocationInfo info = restTemplate.getForObject(endpoint, LocationInfo.class);
    
    return info;
  }
}
