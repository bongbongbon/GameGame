package com.project.gamegame.quiz.controller.SubjectiveQuestion.request;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestionRequest {

    private String question;

    private String answer;
}
