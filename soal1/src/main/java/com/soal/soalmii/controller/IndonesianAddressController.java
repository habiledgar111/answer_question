package com.soal.soalmii.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soal.soalmii.DTO.request.CekAlamatRequest;
import com.soal.soalmii.DTO.response.ApiResponse;
import com.soal.soalmii.service.IndonesianAddressService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/cekAlamat")
public class IndonesianAddressController {
  private IndonesianAddressService indonesianAddressService;

  @PostMapping
  public ResponseEntity<ApiResponse> cekAlamat(@RequestBody CekAlamatRequest request){
    return ResponseEntity.ok(indonesianAddressService.cekAlamat(request.getProvinsi(), request.getKabkota()));
  }
}
