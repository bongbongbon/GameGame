package com.project.gamegame.user.dto.request;

import com.project.gamegame.user.model.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequestDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotBlank
    @Size(max = 13)
    private String phone;

    @NotNull
    @Min(value = 13)
    private Integer age;

    @NotBlank
    private String address;

    @NotBlank
    private String detailAddress;

    private Role role;

}
