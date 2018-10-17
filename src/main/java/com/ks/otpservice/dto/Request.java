package com.ks.otpservice.dto;

import com.ks.otpservice.model.ServiceClient;
import com.ks.otpservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable {

    private long expirationTime;
    private ServiceClient serviceClient;
    private User user;

}
