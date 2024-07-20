package com.project.gamegame.quiz.dto.quiz;


import com.project.gamegame.QuizType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizCreateRequest {

    private String category;

    private String title;

    private String content;

    private String answer;
}
