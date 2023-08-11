package com.example.demo.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.HogeDto;
import com.example.demo.model.TestDto;
import com.example.demo.model.TotalDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserRepository;

@WebMvcTest
public class MyControllerTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MyController myController;

    private MockMvc mockMvc;

   	@Test
    @WithMockUser(username="admin", password="password")
	void posttest() throws Exception {
        UserEntity ue = UserEntity.builder().username("username").password("password").type(1).build();
        TotalDto totalDto = TotalDto.builder().mode("mode").type("type")
            .testDto(TestDto.builder().id("id").name("name").age(19).build())
            .hogeDto(HogeDto.builder().hoge("hoge").fuga("fuga").foo(10)
                .list(List.of(ue)).build())
            .build();
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/web/posttest")
            .flashAttr("totalDto", totalDto)
        );

	}
}
