package com.shlogis.groupware.groupwareapi;


import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "jasypt.encryptor.key=#shlogis"
})
public class JasyptConfigTest {

    @Test
    void jasypt(){
        String secretKey = "#shlogis";

        System.out.printf("%s -> %s", secretKey, jasyptEncoding(secretKey));
    }

    public String jasyptEncoding(String value) {
        String key = "key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
