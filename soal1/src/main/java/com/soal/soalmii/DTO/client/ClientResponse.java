package com.soal.soalmii.DTO.client;

import java.util.List;

import lombok.Data;

@Data
public class ClientResponse<T> {
  private int status;
  private String message;
  private List<T> result;
}
