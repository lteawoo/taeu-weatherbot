package kr.taeu.weatherBot.weather.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WeatherDetail {
  private Integer id;
  private String main;
  private String description;
  private String icon;
}
