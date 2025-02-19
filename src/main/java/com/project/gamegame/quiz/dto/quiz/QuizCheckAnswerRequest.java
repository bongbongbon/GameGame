package com.project.gamegame.quiz.dto.quiz;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizCheckAnswerRequest {

    private Long quizId;

    private String userAnswer;
}
