package com.shlogis.groupware.groupwareapi.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * Jasypt 암호화 설정
 *
 * jasypt-spring-boot-starter가 application.yml의 설정을 자동으로 적용합니다.
 *
 * 사용법:
 * - application.yml에서 jasypt.encryptor.password 설정
 * - 암호화할 값은 ENC(암호화된값) 형식으로 사용
 * - 환경변수 JASYPT_PASSWORD로 키 전달 가능
 */
@Configuration
public class JasyptConfig {
    // jasypt-spring-boot-starter 자동 설정 사용
}
