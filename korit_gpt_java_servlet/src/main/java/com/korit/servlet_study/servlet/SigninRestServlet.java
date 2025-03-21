package com.korit.servlet_study.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.dto.ResponseDto;
import com.korit.servlet_study.dto.SigninDto;
import com.korit.servlet_study.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/api/signin")
public class SigninRestServlet extends HttpServlet {
    private AuthService authService;

    public SigninRestServlet() {
        authService = AuthService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = req.getReader()) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        ObjectMapper objMapper = new ObjectMapper();
        SigninDto dto = objMapper.readValue(stringBuilder.toString(), SigninDto.class);

        ResponseDto<?> responseDto = authService.signin(dto);
        resp.setContentType("application/json");
        resp.setStatus(responseDto.getStatus());
        resp.getWriter().println(objMapper.writeValueAsString(responseDto));
    }
}
