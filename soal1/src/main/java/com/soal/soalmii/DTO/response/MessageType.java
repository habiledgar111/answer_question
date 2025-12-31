package com.soal.soalmii.DTO.response;

public enum MessageType {
  SESUAI("Sesuai"), TIDAK_SESUAI("Tidak Sesuai");

  private final String label;

  MessageType(String label){
    this.label = label;
  }

  public String getLabel(){
    return label;
  }
}
