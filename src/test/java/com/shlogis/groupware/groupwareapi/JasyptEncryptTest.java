package com.shlogis.groupware.groupwareapi;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;

/**
 * Jasypt 암호화 테스트
 * 이 테스트를 실행하여 DB 비밀번호를 암호화할 수 있습니다.
 */
class JasyptEncryptTest {

    private static final String JASYPT_KEY = "shlogis-default-key";

    @Test
    void encryptPassword() {
        // ============================================
        // 여기에 암호화할 비밀번호를 입력하세요
        String plainPassword = "YOUR_PASSWORD_HERE";
        // ============================================

        PooledPBEStringEncryptor encryptor = createEncryptor(JASYPT_KEY);

        String encrypted = encryptor.encrypt(plainPassword);
        String decrypted = encryptor.decrypt(encrypted);

        System.out.println("=====================================");
        System.out.println("Jasypt Encryption Result");
        System.out.println("=====================================");
        System.out.println("Jasypt Key    : " + JASYPT_KEY);
        System.out.println("Plain Text    : " + plainPassword);
        System.out.println("Encrypted     : " + encrypted);
        System.out.println("Decrypted     : " + decrypted);
        System.out.println("=====================================");
        System.out.println("YAML에 적용할 값:");
        System.out.println("password: ENC(" + encrypted + ")");
        System.out.println("=====================================");
    }

    @Test
    void decryptPassword() {
        // ============================================
        // 여기에 복호화할 암호문을 입력하세요
        String encryptedPassword = "wjQ7yIcSwX3PzeEVeN/h5KI0XeyLVmjO";
        // ============================================

        PooledPBEStringEncryptor encryptor = createEncryptor(JASYPT_KEY);

        try {
            String decrypted = encryptor.decrypt(encryptedPassword);
            System.out.println("=====================================");
            System.out.println("Decrypted: " + decrypted);
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("복호화 실패: " + e.getMessage());
        }
    }

    private PooledPBEStringEncryptor createEncryptor(String password) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
