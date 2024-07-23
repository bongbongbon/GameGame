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

}
