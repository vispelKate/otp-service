package com.ks.otpservice.controller;

import com.ks.otpservice.dto.Request;
import com.ks.otpservice.service.OtpCodeService;
import com.ks.otpservice.utils.StatusEnum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpCodeController {

    @Autowired
    OtpCodeService otpCodeService;

    @PostMapping("/send/otp")
    @ApiOperation(value="send new created otp code ")
    @ApiResponses(value={
            @ApiResponse(code=200,message="OK"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="ClientServiceId not found")
    })
    public ResponseEntity sendOtpCode(@RequestBody Request request){
        return ResponseEntity.ok(otpCodeService.sendOtpCode(request));
    }

    @PostMapping("/verify/otp")
    @ApiOperation(value="verify otp code ")
    @ApiResponses(value={
            @ApiResponse(code=200,message="OK"),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="ClientServiceId not found")
    })
    public ResponseEntity verifyOtpCode(){
        return ResponseEntity.ok(StatusEnum.VERIFIED.name());
    }
}
