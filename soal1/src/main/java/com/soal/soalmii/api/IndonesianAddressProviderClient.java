package com.soal.soalmii.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.soal.soalmii.DTO.client.ClientResponse;
import com.soal.soalmii.DTO.client.ResultDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IndonesianAddressProviderClient {
  private final WebClient addressWebClient;

  public ClientResponse<ResultDTO> getProvinsi() {
    return addressWebClient.get()
        .uri("/provinsi/get")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<ClientResponse<ResultDTO>>() {
        })
        .block();
  }

  public ClientResponse<ResultDTO> getCityFromProvinsi(String provinsiId) {
    return addressWebClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/kabkota/get/")
            .queryParam("d_provinsi_id", provinsiId)
            .build())
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<ClientResponse<ResultDTO>>() {
        })
        .block();
  }
}
