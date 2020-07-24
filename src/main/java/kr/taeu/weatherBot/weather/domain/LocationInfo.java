package kr.taeu.weatherBot.weather.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LocationInfo {
  private String lat;
  private String lon;
  private String timezone;
  private String timezone_offset;
  private Weather current;
//  private Weather minutely;
//  private Weather hourly;
//  private Weather daily;
}