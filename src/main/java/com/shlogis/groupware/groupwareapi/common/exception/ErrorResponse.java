package com.shlogis.groupware.groupwareapi.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final int status;
    private final String code;
    private final String message;
    private final String path;
    private final List<FieldErrorDetail> errors;

    @Builder
    private ErrorResponse(int status, String code, String message, String path, List<FieldErrorDetail> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.code = code;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    public static ErrorResponse of(ErrorCode errorCode, String path) {
        return ErrorResponse.builder()
                .status(errorCode.getHttpStatus().value())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .path(path)
                .build();
    }

    public static ErrorResponse of(ErrorCode errorCode, String path, String customMessage) {
        return ErrorResponse.builder()
                .status(errorCode.getHttpStatus().value())
                .code(errorCode.getCode())
                .message(customMessage)
                .path(path)
                .build();
    }

    public static ErrorResponse of(ErrorCode errorCode, String path, BindingResult bindingResult) {
        List<FieldErrorDetail> fieldErrors = bindingResult.getFieldErrors().stream()
                .map(FieldErrorDetail::of)
                .toList();

        return ErrorResponse.builder()
                .status(errorCode.getHttpStatus().value())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .path(path)
                .errors(fieldErrors)
                .build();
    }

    @Getter
    public static class FieldErrorDetail {
        private final String field;
        private final String value;
        private final String reason;

        private FieldErrorDetail(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static FieldErrorDetail of(FieldError fieldError) {
            return new FieldErrorDetail(
                    fieldError.getField(),
                    fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString() : "",
                    fieldError.getDefaultMessage()
            );
        }
    }
}
