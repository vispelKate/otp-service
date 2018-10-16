package com.ks.otpservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ServiceClientDto implements Serializable {

    private String clientId;
    private UUID clientSecret;
}
