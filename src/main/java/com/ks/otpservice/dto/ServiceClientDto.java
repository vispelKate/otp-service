package com.ks.otpservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ServiceClientDto implements Serializable {


    private String clientName;
    private UUID clientSecret;
}
