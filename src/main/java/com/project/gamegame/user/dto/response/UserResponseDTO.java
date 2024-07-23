package com.project.gamegame.user.dto.response;

import com.project.gamegame.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {

    private String email;


    public static UserResponseDTO fromEntity(User user) {
        return UserResponseDTO.builder()
                .email(user.getEmail())
                .build();
    }
}
