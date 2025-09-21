package com.shlogis.groupware.groupwareapi.sample.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    //resouces -> mapper 경로에 작성한 명명 과 똑같이 사용한다.
    // List<SampleDto> selectAllListUser(String id);
}
