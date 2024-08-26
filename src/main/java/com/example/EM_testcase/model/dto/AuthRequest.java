package com.example.EM_testcase.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @Schema(description = "Электронная почта", example = "abc@gmail.com")
    @Email(message = "Почта должна быть в формате ex@example.com")
    @NotBlank(message = "В поле нужно ввести почту")
    private String email;

    @Schema(description = "Пароль", example = "12345pass")
    private String password;
}
