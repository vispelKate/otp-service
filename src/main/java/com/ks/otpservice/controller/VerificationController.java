package com.ks.otpservice.controller;

import com.ks.otpservice.utils.RouteConsts;
import com.ks.otpservice.utils.VerificationStatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RouteConsts.VERIFY_OTP)
public class VerificationController {

    @PostMapping
    public ResponseEntity verifyOtpCode(){
        return ResponseEntity.ok(VerificationStatusEnum.VERIFIED.name());
    }
}
