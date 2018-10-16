package com.ks.otpservice.service;

import com.ks.otpservice.dto.Request;
import com.ks.otpservice.utils.StatusEnum;

public interface OtpCodeService {

    StatusEnum sendOtpCode(Request request);
}
