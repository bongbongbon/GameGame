package com.project.gamegame.quiz.domain;

import com.project.gamegame.QuizType;
import com.project.gamegame.common.model.BaseEntity;
import com.project.gamegame.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Quiz extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    private String category;

    private String title;

    private String content;

    private String answer;

//    private User user;
}
