package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.model.UserEntity;

@Controller
//セッションに保存する情報は@SessionAttributesアノテーションで指定する
@SessionAttributes(types = UserEntity.class) 
@RequestMapping("/")
public class SessionController {
	//セッションに保存するオブジェクトの本体は、メソッドに@ModelAttributeアノテーションを付けて作成する
	@ModelAttribute("user")
	public UserEntity user() {
		return new UserEntity();
	}

	@RequestMapping("login")
	public String login(@ModelAttribute UserEntity user,HttpSession httpSession) {
		return "index";
	}
}
