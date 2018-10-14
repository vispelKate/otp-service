package com.ks.otpservice.controller;


import com.ks.otpservice.utils.VerificationStatusEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateOtpCodeControllerIntegrationTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp()  {
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getOtpCode() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/generate/otp"))
                .andExpect(status().isOk())
                .andExpect(content().string(VerificationStatusEnum.CODE_SENT.name()))
                .andDo(print());
    }
}