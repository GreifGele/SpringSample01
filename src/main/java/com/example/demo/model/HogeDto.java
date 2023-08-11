package com.example.demo.model;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class HogeDto {
    @NotEmpty
    private String hoge;
    @NotEmpty
    private String fuga;
    @Range(min = 100, max = 200)
    private int foo;
    @Valid
    private List<UserEntity> list;
}
