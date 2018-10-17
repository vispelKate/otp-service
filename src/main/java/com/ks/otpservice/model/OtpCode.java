package com.ks.otpservice.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class OtpCode {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @NotNull
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @NotNull
    private LocalDateTime expiredAt;

    @Min(111111)
    @Max(999999)
    @NotNull
    private Integer otpCode;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clientId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ServiceClient client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;



}
