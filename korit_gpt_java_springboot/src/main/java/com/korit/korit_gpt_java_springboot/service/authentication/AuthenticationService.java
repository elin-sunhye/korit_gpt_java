package com.korit.korit_gpt_java_springboot.service.authentication;

import com.korit.korit_gpt_java_springboot.dto.request.authentication.ReqSigninDto;
import com.korit.korit_gpt_java_springboot.dto.request.authentication.ReqSignupDto;
import com.korit.korit_gpt_java_springboot.entity.user.User;
import com.korit.korit_gpt_java_springboot.entity.user.UserRole;
import com.korit.korit_gpt_java_springboot.exception.CustomDuplicateKeyException;
import com.korit.korit_gpt_java_springboot.repository.user.UserRepository;
import com.korit.korit_gpt_java_springboot.repository.user.UserRoleRepository;
import com.korit.korit_gpt_java_springboot.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @Transactional(rollbackFor = Exception.class)
    public User signup(ReqSignupDto reqSignupDto) {
        User user = reqSignupDto.toUser(passwordEncoder);
        User saveUser = userRepository
                .save(user)
                .orElseThrow(() -> new CustomDuplicateKeyException("이미 존재하는 사용자이름입니다.", Map.of("username", "이미 존재하는 사용자이름입니다.")));
        userRoleRepository.save(UserRole.builder()
                        .userId(user.getUserId())
                        .roleId(1)
                        .build());
        return saveUser;
    }

    public String signin(ReqSigninDto reqSigninDto) {
        String accessToken = null;

        // username 확인
        User foundUser = userRepository
                .findByUsername(reqSigninDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("사용자 정보를 다시 확인하세요."));

        // password 확인
        if(!passwordEncoder.matches(reqSigninDto.getPassword(), foundUser.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 다시 확인하세요.");
        }

        // AccessToken 생성
        accessToken = jwtProvider.createAccessToken(foundUser);

        return accessToken;
    }
}










