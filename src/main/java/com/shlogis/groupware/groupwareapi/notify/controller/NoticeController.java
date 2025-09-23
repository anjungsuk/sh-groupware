package com.shlogis.groupware.groupwareapi.notify.controller;


import com.shlogis.groupware.groupwareapi.notify.dto.request.NoticeApiSO;
import com.shlogis.groupware.groupwareapi.notify.dto.response.NoticeResponseDto;
import com.shlogis.groupware.groupwareapi.notify.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/board/v1")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public ResponseEntity<?> list(NoticeApiSO noticeApi) {

        List<NoticeResponseDto> list = noticeService.noticeList(noticeApi);

        return ResponseEntity.ok(noticeApi);
    }

}
