package com.bahinskyi.advertisement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.misc.BASE64Encoder;

/**
 * Created by kostya on 05.06.17.
 */
public class EncryptPass {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder(12).encode("qwerty"));
//        new BASE64Encoder()
    }
}
