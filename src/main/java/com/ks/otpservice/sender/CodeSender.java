package com.ks.otpservice.sender;

import com.ks.otpservice.model.Message;

public interface CodeSender {

    void send(String routingKey, Message message);

}
