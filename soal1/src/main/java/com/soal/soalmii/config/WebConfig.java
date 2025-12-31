package com.soal.soalmii.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

  @Bean
  public WebClient addressWebClient(WebClient.Builder builder) {
    return builder.baseUrl("https://alamat.thecloudalert.com/api")
        .build();
  }
}
