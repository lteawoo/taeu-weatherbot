package kr.taeu.weatherBot.weather.domain;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Weather {
   private Long dt;
   private Double temp;
   private Double feelsLike;
   private Double humidity;
   private Double clouds;
   private Double windSpeed;
   private List<WeatherDetail> weather;
}
