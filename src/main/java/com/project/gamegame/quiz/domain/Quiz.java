package com.project.gamegame.quiz.domain;

import com.project.gamegame.QuizType;
import com.project.gamegame.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    private String quizType;

    private String title;

    private String content;

    private String answer;

//    private User user;
}
