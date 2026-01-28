package com.shlogis.groupware.groupwareapi.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common Errors (1000번대)
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C002", "잘못된 타입입니다."),
    MISSING_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "C003", "필수 파라미터가 누락되었습니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "C004", "요청한 리소스를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C005", "허용되지 않은 HTTP 메서드입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C006", "서버 내부 오류가 발생했습니다."),
    INVALID_JSON_FORMAT(HttpStatus.BAD_REQUEST, "C007", "잘못된 JSON 형식입니다."),

    // Authentication & Authorization Errors (2000번대)
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "A001", "인증이 필요합니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "A002", "접근 권한이 없습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "A003", "유효하지 않은 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "A004", "만료된 토큰입니다."),

    // User Errors (3000번대)
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001", "사용자를 찾을 수 없습니다."),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "U002", "이미 존재하는 이메일입니다."),
    DUPLICATE_USER_ID(HttpStatus.CONFLICT, "U003", "이미 존재하는 사용자 ID입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "U004", "잘못된 비밀번호입니다."),

    // Board/Notice Errors (4000번대)
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "B001", "게시글을 찾을 수 없습니다."),
    BOARD_ACCESS_DENIED(HttpStatus.FORBIDDEN, "B002", "게시글에 대한 접근 권한이 없습니다."),
    INVALID_BOARD_CATEGORY(HttpStatus.BAD_REQUEST, "B003", "잘못된 게시판 카테고리입니다."),

    // File Errors (5000번대)
    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "F001", "파일을 찾을 수 없습니다."),
    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "F002", "파일 업로드에 실패했습니다."),
    INVALID_FILE_TYPE(HttpStatus.BAD_REQUEST, "F003", "허용되지 않은 파일 형식입니다."),
    FILE_SIZE_EXCEEDED(HttpStatus.BAD_REQUEST, "F004", "파일 크기가 제한을 초과했습니다."),

    // Database Errors (6000번대)
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "D001", "데이터베이스 오류가 발생했습니다."),
    DUPLICATE_KEY(HttpStatus.CONFLICT, "D002", "중복된 데이터가 존재합니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
