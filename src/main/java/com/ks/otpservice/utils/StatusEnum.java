package com.ks.otpservice.utils;

public enum StatusEnum {

    CODE_SENT("code sent"),

    VERIFIED("verified"),

    INVALID_CODE("invalid code"),

    CODE_EXISTS("code exists"),

    ERROR("error");

    StatusEnum(String verified) {
    }
}
