package com.ks.otpservice.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OtpCodeGeneratorTest {

    @Test
    public void generateOtpCodeTest() {

        assertThat(OtpCodeGenerator.generateCode()).isBetween(100000, 999999);

    }
}
