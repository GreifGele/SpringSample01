package com.example.demo.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TotalDto {
    @NotBlank
    String mode;
    @NotBlank
    String type;

    @Valid
    TestDto testDto;
    @Valid
    HogeDto hogeDto;
    
}
