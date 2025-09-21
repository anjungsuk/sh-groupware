package com.shlogis.groupware.groupwareapi.sample.service;


import com.shlogis.groupware.groupwareapi.sample.mapper.SampleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    //Bean 주입은 항상 RequiredArgsConstructor 사용 하여 호출한다. -> Spring 기본 권고 방식
    private final SampleMapper sampleMapper;

    // 서비스 메서드 사용 방식 예시
   public void getAllUsers() {
//        List<UserDto> users = new ArrayList<>();
//        userStore.forEach((id, name) -> users.add(sampleMapper.toDto(id, name)));
//        return users;
    }

}
