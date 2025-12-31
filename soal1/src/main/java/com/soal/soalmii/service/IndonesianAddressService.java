package com.soal.soalmii.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soal.soalmii.DTO.client.ResultDTO;
import com.soal.soalmii.DTO.response.ApiResponse;
import com.soal.soalmii.DTO.response.MessageType;
import com.soal.soalmii.api.IndonesianAddressProviderClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndonesianAddressService {
  private IndonesianAddressProviderClient indonesianAddressProviderClient;
  
  public List<ResultDTO> getAllProvinsi(){
    return indonesianAddressProviderClient.getProvinsi().getResult();
  }

  public List<ResultDTO> getAllCity(String id){
    return indonesianAddressProviderClient.getCityFromProvinsi(id).getResult();
  }

  public ApiResponse cekAlamat(String provinsi, String kota){
    List<ResultDTO> provinsiAfterFiler =  getAllProvinsi().stream().filter(p -> p.getText().equalsIgnoreCase(provinsi)).toList();

    if(provinsiAfterFiler.isEmpty()){
      return new ApiResponse(0,MessageType.TIDAK_SESUAI.getLabel());
    }
    
    boolean cityIsExist = false;
    // untuk mencegah semisal jika ada nama provinsi yang sama 
    for(int i = 0; i< provinsiAfterFiler.size();i++){
      cityIsExist = getAllCity(provinsiAfterFiler.get(i).getId()).stream().anyMatch(k -> k.getText().equalsIgnoreCase(kota));
    }

    if(!cityIsExist){
      return new ApiResponse(0, MessageType.TIDAK_SESUAI.getLabel());
    }

    return new ApiResponse(1, MessageType.SESUAI.getLabel());
  }
}
