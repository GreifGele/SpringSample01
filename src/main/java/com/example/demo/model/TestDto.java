package com.example.demo.model;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TestDto {

    @NotBlank
    String id;

    @NotBlank
    String name;

    @Range(min = 10, max = 30)
    int age;
}
