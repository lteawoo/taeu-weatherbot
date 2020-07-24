package kr.taeu.weatherBot.weather;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import kr.taeu.weatherBot.weather.domain.LocationInfo;
import kr.taeu.weatherBot.weather.dto.CurrentWeatherResponse;
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
    CurrentWeatherResponse res = getCurrentWeather();
    log.info("format: " + getCurrentWeather());
    String dt = LocalDateTime.ofInstant(Instant.ofEpochSecond(res.getDt()), TimeZone.getDefault().toZoneId())
       .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    log.info(dt);
    
    return "test";
  }
  
  private LocationInfo callApi() {
    RestTemplate restTemplate = new RestTemplate();
    String endpoint = WEATHER_API_ENDPOINT + "&lat=" + seoulLatitude + "&lon=" + seoulLongtitude;
    LocationInfo info = restTemplate.getForObject(endpoint, LocationInfo.class);
    
    return info;
  }
  
  public CurrentWeatherResponse getCurrentWeather() {
    return new CurrentWeatherResponse(callApi());
  }
}
