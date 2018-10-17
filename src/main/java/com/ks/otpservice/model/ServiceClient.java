package com.ks.otpservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServiceClient {

    @Id
    private int clientId;
    @NotNull
    private String clientName;
    @NotNull
    private UUID clientSecret;
}
