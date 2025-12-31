package com.soal.soalmii.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soal.soalmii.DTO.client.ResultDTO;
import com.soal.soalmii.service.IndonesianAddressService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class IndonesianAddressController {
  private IndonesianAddressService indonesianAddressService;

  @GetMapping
  public ResponseEntity<List<ResultDTO>> getPronvisi(){
    return ResponseEntity.ok(indonesianAddressService.getAllProvinsi());
  }

  @GetMapping("/city/{pId}")
  public ResponseEntity<List<ResultDTO>> getCity(@PathVariable String pId){
    return ResponseEntity.ok(indonesianAddressService.getAllCity(pId));
  }
}
