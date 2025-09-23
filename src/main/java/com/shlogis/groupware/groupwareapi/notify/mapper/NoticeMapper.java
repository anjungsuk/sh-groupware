package com.shlogis.groupware.groupwareapi.notify.mapper;

import com.shlogis.groupware.groupwareapi.notify.dto.request.NoticeApiSO;
import com.shlogis.groupware.groupwareapi.notify.dto.response.NoticeResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeResponseDto> selectNoticeList(NoticeApiSO noticeApiSO);
}
