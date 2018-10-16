package com.ks.otpservice.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class OtpCode implements Serializable {

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @NotNull
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @NotNull
    private LocalDate expiredAt;

    @Min(111111)
    @Max(999999)
    @NotNull
    private Integer otpCode;

    private ServiceClient client;

    private User user;



}
