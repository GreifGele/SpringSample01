package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TestDto;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @GetMapping(value = "/test")
    String test(@RequestParam String name, @RequestParam String id, @RequestParam int age) {
        return "test";
    }

    @GetMapping(value = "/testtest")
    String testtest(@ModelAttribute TestDto testDto) {
        return "testtest";
    }

    @PostMapping(value = "/posttest")
    String posttest() {
        return "test";
    }

}
