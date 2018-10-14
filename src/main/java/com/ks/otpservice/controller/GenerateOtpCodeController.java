package com.ks.otpservice.controller;

import com.ks.otpservice.utils.RouteConsts;
import com.ks.otpservice.utils.VerificationStatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RouteConsts.GENERATE_OTP_CODE)
public class GenerateOtpCodeController {

    @PostMapping
    public ResponseEntity generateOtpCode(){
        return ResponseEntity.ok(VerificationStatusEnum.CODE_SENT.name());
    }
}
