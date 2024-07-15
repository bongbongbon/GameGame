package com.project.gamegame.quiz.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@SuperBuilder
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}
