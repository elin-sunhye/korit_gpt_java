package com.korit.korit_gpt_java_springboot.dto.response.common;

import lombok.Getter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@Getter
@ApiModel(description = "응답 DTO")
public class ResponseDto<T> {
    @ApiModelProperty(value = "응답 시간", example = "2000-01-01T12:00:00.00")
    private final String timestamp;
    @ApiModelProperty(value = "응답 데이터")
    private final T data;

    public ResponseDto(T data) {
        timestamp = String.valueOf(LocalDateTime.now());
        this.data = data;
    }
}
