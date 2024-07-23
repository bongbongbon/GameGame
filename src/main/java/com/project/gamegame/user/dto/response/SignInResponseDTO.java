package com.project.gamegame.user.dto.response;

import com.project.gamegame.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInResponseDTO {
    private long id;

    private String email;

    private String role;

    private String phone;

    private String name;

    private String token;

    public SignInResponseDTO(String token, User user) {
        this.id = user.getId();
        this.email = user.getEmail();
//        this.name = user.getName();
//        this.role = user. getRole();
//        this.phone = user.getPhone();
        this.token = token;
    }
}
