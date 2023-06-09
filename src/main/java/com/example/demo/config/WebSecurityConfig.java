package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.handler.AccessDeniedHandlerImpl;
import com.example.demo.handler.AuthEntryPointImpl;
import com.example.demo.handler.AuthFailureHandlerImpl;
import com.example.demo.handler.AuthSuccessHandlerImpl;
import com.example.demo.handler.InvalidSessionStrategyImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()
        ).formLogin(login -> login
                .loginProcessingUrl("/login_proc")
                .loginPage("/login")
                .failureHandler(new AuthFailureHandlerImpl())
                .successHandler(new AuthSuccessHandlerImpl())
                .permitAll()
        ).logout(logout -> logout
                .logoutSuccessUrl("/")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/general").hasRole("GENERAL")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).sessionManagement(ses -> ses
                .sessionAuthenticationFailureHandler(new AuthFailureHandlerImpl())
                // セッション切れ時のストラテジ実装
                .invalidSessionStrategy(new InvalidSessionStrategyImpl())
        ).exceptionHandling(ex -> ex
                .accessDeniedHandler(new AccessDeniedHandlerImpl())
                // 未認証ユーザに401返却
                .authenticationEntryPoint(new AuthEntryPointImpl())
        );
        return http.build();
    }

    //フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
