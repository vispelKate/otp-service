package com.ks.otpservice.utils;

import org.apache.commons.math3.random.RandomDataGenerator;

public class OtpCodeGenerator {

    private static Integer MIN_RANGE = 100000;
    private static Integer MAX_RANGE = 999999;

    public static Integer generateCode() {

        return new RandomDataGenerator().nextInt(MIN_RANGE,MAX_RANGE);

    }

}
