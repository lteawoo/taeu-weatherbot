package kr.taeu.weatherBot.weather.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LocationInfo {
  private Double lat;
  private Double lon;
  private String timezone;
  private Long timezoneOffset;
  private Weather current;
//  private Weather minutely;
//  private Weather hourly;
//  private Weather daily;
}