package com.ks.otpservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ServiceClient {

    private String clientId;
    private UUID clientSecret;
}
