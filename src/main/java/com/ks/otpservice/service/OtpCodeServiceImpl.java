package com.ks.otpservice.service;

import com.ks.otpservice.dto.Request;
import com.ks.otpservice.model.Message;
import com.ks.otpservice.model.OtpCode;
import com.ks.otpservice.model.User;
import com.ks.otpservice.repository.OtpCodeRepository;
import com.ks.otpservice.repository.UserRepository;
import com.ks.otpservice.sender.CodeSender;
import com.ks.otpservice.utils.OtpCodeGenerator;
import com.ks.otpservice.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class OtpCodeServiceImpl implements OtpCodeService {

    @Autowired
    private OtpCodeRepository otpCodeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CodeSender codeSender;

    @Value("${otp.service.rabbitmq.email.routingkey}")
    private String emailRoutingkey;

    @Value("${otp.service.rabbitmq.sms.routingkey}")
    private String smsRoutingkey;

    @Override
    public StatusEnum sendOtpCode(Request request) {
        OtpCode otpCode = createOtpCode(request);
        try {
            if(!userRepository.existsById(otpCode.getUser().getUserId())) {
                userRepository.save(otpCode.getUser());
            }
            otpCodeRepository.save(otpCode);
            codeSender.send(getRoutingKey(request.getUser()),
                    createMessage(otpCode));
            return StatusEnum.CODE_SENT;
        } catch (Exception e) {
            return StatusEnum.ERROR;
        }
    }

    private OtpCode createOtpCode(Request request) {
        return OtpCode.builder()
                .client(request.getServiceClient())
                .user(request.getUser())
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusSeconds(request.getExpirationTime()) )
                .otpCode(OtpCodeGenerator.generateCode())
                .build();
    }



    private Message createMessage(OtpCode otpCode) {
        User user = otpCode.getUser();
        return Message.builder()
                .contact(
                        StringUtils.isEmpty(user.getEmail()) ?
                        user.getPhone() : user.getEmail()
                )
                .otpCode(otpCode.getOtpCode()).build();
    }

    private String getRoutingKey(User user) {
        return StringUtils.isEmpty(user.getEmail()) ? smsRoutingkey :
                emailRoutingkey;
    }
}
