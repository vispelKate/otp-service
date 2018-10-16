package com.ks.otpservice.service;

import com.ks.otpservice.model.Message;
import com.ks.otpservice.dto.Request;
import com.ks.otpservice.model.User;
import com.ks.otpservice.sender.CodeSender;
import com.ks.otpservice.utils.OtpCodeGenerator;
import com.ks.otpservice.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OtpCodeServiceImpl implements OtpCodeService {

    @Autowired
    private CodeSender codeSender;

    @Value("${otp.service.rabbitmq.email.routingkey}")
    private String emailRoutingkey;

    @Value("${otp.service.rabbitmq.sms.routingkey}")
    private String smsRoutingkey;

    @Override
    public StatusEnum sendOtpCode(Request request) {
        User user = request.getUser();
        try{
            codeSender.send(getRoutingKey(user),
                    createMessage(user));
            return StatusEnum.CODE_SENT;
        } catch (Exception e) {
            return StatusEnum.ERROR;
        }
    }

    private Message createMessage(User user) {
        return Message.builder()
                .contact(
                        StringUtils.isEmpty(user.getEmail()) ?
                        user.getPhone() : user.getEmail()
                )
                .otpCode(OtpCodeGenerator.generateCode()).build();
    }

    private String getRoutingKey(User user) {
        return StringUtils.isEmpty(user.getEmail()) ? smsRoutingkey :
                emailRoutingkey;
    }
}
