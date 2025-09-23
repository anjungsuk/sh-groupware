package com.shlogis.groupware.groupwareapi.notify.service;


import com.shlogis.groupware.groupwareapi.notify.dto.request.NoticeApiSO;
import com.shlogis.groupware.groupwareapi.notify.dto.response.NoticeResponseDto;
import com.shlogis.groupware.groupwareapi.notify.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public List<NoticeResponseDto> noticeList(NoticeApiSO noticeApi) {

        return noticeMapper.selectNoticeList(noticeApi);

    }
}
