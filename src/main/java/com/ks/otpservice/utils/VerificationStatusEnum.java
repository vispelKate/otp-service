package com.ks.otpservice.utils;

public enum VerificationStatusEnum {

    CODE_SENT("code sent"),

    VERIFIED("verified"),

    INVALID_CODE("invalid code"),

    CODE_EXISTS("code exists"),

    ERROR("error");

    VerificationStatusEnum(String verified) {
    }
}
