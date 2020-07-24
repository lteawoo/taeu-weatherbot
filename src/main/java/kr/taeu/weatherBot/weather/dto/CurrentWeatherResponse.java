package kr.taeu.weatherBot.weather.dto;

import kr.taeu.weatherBot.weather.domain.LocationInfo;
import kr.taeu.weatherBot.weather.domain.WeatherDetail;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CurrentWeatherResponse {
  private Long dt;
  private String timezone;
  private Long timezoneOffset;
  private Double temp;
  private Double feelsLike;
  private Double humidity;
  private Double clouds;
  private Double windSpeed;
  private String weatherMain;
  private String weatherDescription;
  
  public CurrentWeatherResponse(LocationInfo info) {
     this.dt = info.getCurrent().getDt();
     this.timezone = info.getTimezone();
     this.timezoneOffset = info.getTimezoneOffset();
     this.temp = info.getCurrent().getTemp();
     this.feelsLike = info.getCurrent().getFeelsLike();
     this.humidity = info.getCurrent().getHumidity();
     this.clouds = info.getCurrent().getClouds();
     this.windSpeed = info.getCurrent().getWindSpeed();
     
     WeatherDetail weatherDtl = info.getCurrent().getWeather().get(0);
     this.weatherMain = weatherDtl.getMain();
     this.weatherDescription = weatherDtl.getDescription();
  }
}
