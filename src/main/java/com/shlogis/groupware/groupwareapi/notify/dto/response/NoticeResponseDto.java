package com.shlogis.groupware.groupwareapi.notify.dto.response;


import lombok.Data;

@Data
public class NoticeResponseDto {

    //NO
    private int boardNo;
    //categoryCd
    private String categoryCd;
    //title
    private String title;
    //writerNm
    private String writerNm;
    //viewCnt
    private Integer viewCnt;
    //regDt
    private String regDt;
}
