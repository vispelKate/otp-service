package com.ks.otpservice.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private Integer otpCode;
    private String contact;

}
