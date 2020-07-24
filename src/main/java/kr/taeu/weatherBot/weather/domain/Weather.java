package kr.taeu.weatherBot.weather.domain;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Weather {
   private String dt;
   private String temp;
   private String feels_like;
   private String humidity;
   private String clouds;
   private String wind_speed;
   private List<WeatherDetail> weather;
}
