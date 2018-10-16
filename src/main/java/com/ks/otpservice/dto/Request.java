package com.ks.otpservice.dto;

import com.ks.otpservice.model.ServiceClient;
import com.ks.otpservice.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Request implements Serializable {

    private long expirationTime;
    private ServiceClient serviceClient;
    private User user;

}
