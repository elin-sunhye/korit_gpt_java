package com.korit.springboot_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/** token 저장 redis */
@Service
public class RedisTokenService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setRefresh(String username, String token, Duration duration) {
        redisTemplate.opsForValue().set("refresh:" + username, token, duration);
    }

    public void setAccess(String username, String token, Duration duration) {
        redisTemplate.opsForValue().set("access:" + username, token, duration);
    }

    public String getRefreshToken(String username ) {
        return (String) redisTemplate.opsForValue().get("refresh:" + username);
    }
}
