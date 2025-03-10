package com.korit.springboot_security.dto.response.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAuthDto {
    private String accessToken;
    private String refreshToken;
}
