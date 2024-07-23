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
<<<<<<< HEAD
    private long id;
=======

    private Long id;
>>>>>>> 0df2e05b9cd5255cf119ec5b6b2c2b21c4fafad6

    private String username;

    private String password;

    private String email;
}
