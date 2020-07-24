package kr.taeu.weatherBot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Configuration
public class RestConfig {
  
  private ObjectMapper jacksonObjectMapper() {
    return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
  }
  
  private MappingJackson2HttpMessageConverter createMappingJacksonHttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(jacksonObjectMapper());
    return converter;
  }
  
  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(0, createMappingJacksonHttpMessageConverter());
    return restTemplate;
  }
}