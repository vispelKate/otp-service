package com.ks.otpservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private long userId;
    private String email;
    private String phone;


}
