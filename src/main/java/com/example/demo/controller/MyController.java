package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.HogeDto;
import com.example.demo.model.TestDto;
import com.example.demo.model.TotalDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/web")
@Slf4j
public class MyController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "hello world");
        TestDto testDto = TestDto.builder().id("id1").name("name1").age(29).build();
        List<UserEntity> list = userRepository.findAll();
        HogeDto hogeDto = HogeDto.builder().hoge("hoge").fuga("fuga").foo(105).list(list).build();
        TotalDto totalDto = TotalDto.builder()
            .mode("mode").type("type")
            .testDto(testDto).hogeDto(hogeDto).build();
        model.addAttribute("totalDto", totalDto);
        return "test";
    }

    @PostMapping("/posttest")
    public String postTest(@Validated @ModelAttribute TotalDto totalDto, BindingResult result, Model model) throws Exception {
        log.info(result.toString());

        if (result.hasErrors()) {
            log.info(String.join(", ", result.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList()));
        }

        model.addAttribute("totalDto", totalDto);
        return "test";
    }

    @PostMapping("/posttest2")
    public String postTest2(
        @Validated @ModelAttribute TestDto testDto,
        String mode,
        String type,
        @Validated @ModelAttribute HogeDto hogeDto,
        BindingResult result, Model model) throws Exception {
        log.info(result.toString());

        if (result.hasErrors()) {
            log.info(String.join(", ", result.getAllErrors().stream().map(e -> e.getDefaultMessage()).toList()));
        }

        TotalDto totalDto = TotalDto.builder()
            .mode(mode).type(type)
            .testDto(testDto).hogeDto(hogeDto).build();
        model.addAttribute("totalDto", totalDto);
        return "test";
    }
}
