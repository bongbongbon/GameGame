package com.project.gamegame.user.dto.response;

import com.project.gamegame.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private Long id;

    private String username;

    private String password;

    private String email;
}
