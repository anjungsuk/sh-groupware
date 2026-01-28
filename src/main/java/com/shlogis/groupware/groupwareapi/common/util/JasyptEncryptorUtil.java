package com.shlogis.groupware.groupwareapi.common.util;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * Jasypt 암호화/복호화 유틸리티
 *
 * 사용법:
 *   java -cp "build/libs/*" com.shlogis.groupware.groupwareapi.common.util.JasyptEncryptorUtil encrypt [암호화키] [평문]
 *   java -cp "build/libs/*" com.shlogis.groupware.groupwareapi.common.util.JasyptEncryptorUtil decrypt [암호화키] [암호문]
 *
 * 또는 IDE에서 직접 실행하여 테스트
 */
public class JasyptEncryptorUtil {

    private static final String DEFAULT_KEY = "shlogis-default-key";

    public static void main(String[] args) {
        if (args.length < 2) {
            printUsage();
            // 기본 테스트 실행
            runDefaultTest();
            return;
        }

        String command = args[0];
        String key = args.length >= 3 ? args[1] : DEFAULT_KEY;
        String text = args.length >= 3 ? args[2] : args[1];

        PooledPBEStringEncryptor encryptor = createEncryptor(key);

        switch (command.toLowerCase()) {
            case "encrypt", "enc", "e" -> {
                String encrypted = encryptor.encrypt(text);
                System.out.println("====================================");
                System.out.println("Original: " + text);
                System.out.println("Encrypted: " + encrypted);
                System.out.println("For YAML: ENC(" + encrypted + ")");
                System.out.println("====================================");
            }
            case "decrypt", "dec", "d" -> {
                String decrypted = encryptor.decrypt(text);
                System.out.println("====================================");
                System.out.println("Encrypted: " + text);
                System.out.println("Decrypted: " + decrypted);
                System.out.println("====================================");
            }
            default -> printUsage();
        }
    }

    private static void runDefaultTest() {
        System.out.println("\n========== 기본 테스트 ==========");
        String testPassword = "your-db-password";

        PooledPBEStringEncryptor encryptor = createEncryptor(DEFAULT_KEY);
        String encrypted = encryptor.encrypt(testPassword);
        String decrypted = encryptor.decrypt(encrypted);

        System.out.println("Key: " + DEFAULT_KEY);
        System.out.println("Original: " + testPassword);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println("For YAML: ENC(" + encrypted + ")");
        System.out.println("====================================");
    }

    private static void printUsage() {
        System.out.println("Jasypt Encryptor Utility");
        System.out.println("Usage:");
        System.out.println("  encrypt [key] <text>  - Encrypt text");
        System.out.println("  decrypt [key] <text>  - Decrypt text");
        System.out.println("");
        System.out.println("Examples:");
        System.out.println("  encrypt my-secret-password");
        System.out.println("  encrypt my-key my-secret-password");
        System.out.println("  decrypt my-key abc123encrypted");
    }

    public static PooledPBEStringEncryptor createEncryptor(String password) {
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

    /**
     * 프로그래밍 방식으로 암호화
     */
    public static String encrypt(String key, String plainText) {
        return createEncryptor(key).encrypt(plainText);
    }

    /**
     * 프로그래밍 방식으로 복호화
     */
    public static String decrypt(String key, String encryptedText) {
        return createEncryptor(key).decrypt(encryptedText);
    }
}
