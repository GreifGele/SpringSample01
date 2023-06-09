package com.example.demo.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.InvalidSessionStrategy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InvalidSessionStrategyImpl implements InvalidSessionStrategy {

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
                // mobile の場合は 401エラー
                response.setStatus(HttpStatus.UNAUTHORIZED.value());

                // pc の場合は session にデータ格納して login 画面に遷移
                //new DefaultRedirectStrategy().sendRedirect(request, response, "/login");
    }
    
}
