package com.shlogis.groupware.groupwareapi.sample.dto;


import lombok.*;

@Data                   // Getter, Setter, toString, equals, hashCode 자동 생성
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 모든 필드 생성자
public class sampleDto {
    private Long id;
    private String name;
}
