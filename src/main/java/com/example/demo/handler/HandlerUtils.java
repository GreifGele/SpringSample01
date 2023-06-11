package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandlerUtils {
    public static void onAuthFailure(HttpServletRequest request, HttpServletResponse response) {
                // mobile の場合は 401エラー
                response.setStatus(HttpStatus.UNAUTHORIZED.value());

                // pc の場合は session を破棄して login 画面に遷移
                //request.getSession().invalidate();
                //new DefaultRedirectStrategy().sendRedirect(request, response, "/login");
    }
}
