package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            UserEntity entity = userRepository.findById(username).get();
            String pass = webSecurityConfig.passwordEncoder().encode(entity.getPassword());
            entity.setPassword(pass);
            entity.CreateAuthorityList();
            // 認可があればここで設定できる
            // org.springframework.security.core.userdetails.Userにして返却する
            // パスワードエンコーダを利用してパスワードはエンコードをかける
            return entity;
        }catch (Exception e) {
            throw new UsernameNotFoundException("ユーザーが見つかりません");
        }
    }
}
