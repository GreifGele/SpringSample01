package com.example.demo.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandlerUtils {
    public static boolean isMobile(HttpServletRequest request) {
        String ua = request.getHeader("user-agent");
        return ua.toLowerCase().contains("mobile");
    }

    public static void onAuthFailure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (isMobile(request)) {
            // mobile の場合は 401エラー
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        else {
            // pc の場合は session を破棄して login 画面に遷移
            request.getSession().invalidate();
            new DefaultRedirectStrategy().sendRedirect(request, response, "/login");
        }
    }

    public static void onAuthSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (isMobile(request)) {
            // mobile の場合は 200 ok
            response.setStatus(HttpStatus.OK.value());
        }
        else {
            // pc の場合は指定画面に遷移
            new DefaultRedirectStrategy().sendRedirect(request, response, "/hello");
        }
    }
}
