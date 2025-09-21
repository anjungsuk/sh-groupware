package com.shlogis.groupware.groupwareapi.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI groupwareOpenAPI() {
        return new OpenAPI().info(new Info().title("Groupware API").description("그룹웨어 프로젝트 API").version("1.0"));
    }
}
