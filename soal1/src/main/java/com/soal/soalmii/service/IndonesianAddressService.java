package com.soal.soalmii.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soal.soalmii.DTO.client.ClientResponse;
import com.soal.soalmii.DTO.client.ResultDTO;
import com.soal.soalmii.api.IndonesianAddressProviderClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndonesianAddressService {
  private IndonesianAddressProviderClient indonesianAddressProviderClient;
  
  public List<ResultDTO> getAllProvinsi(){
    ClientResponse<ResultDTO> response = indonesianAddressProviderClient.getProvinsi();

    if(response == null || response.getStatus() != 200){
      throw new RuntimeException("Data Tidak Ada Saat Consume Api");
    }

    return response.getResult();
  }

  public List<ResultDTO> getAllCity(String id){
    ClientResponse<ResultDTO> response = indonesianAddressProviderClient.getCityFromProvinsi(id);

    if(response == null || response.getStatus() != 200){
      throw new RuntimeException("Data Tidak Ada Saat Consume Api");
    }

    return response.getResult();
  }
}
