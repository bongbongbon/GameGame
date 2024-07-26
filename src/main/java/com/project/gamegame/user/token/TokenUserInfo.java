package com.project.gamegame.user.token;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TokenUserInfo {

    private Long id;

    private String email;

    private String phone;

    private String name;
}
