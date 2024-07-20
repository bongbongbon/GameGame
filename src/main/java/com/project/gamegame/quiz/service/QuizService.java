package com.project.gamegame.quiz.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.quiz.domain.Quiz;
import com.project.gamegame.quiz.dto.quiz.QuizCheckAnswerRequest;
import com.project.gamegame.quiz.dto.quiz.QuizCreateRequest;
import com.project.gamegame.quiz.dto.quiz.QuizResponse;
import com.project.gamegame.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    // 퀴즈 만들기
    public void createQuiz(QuizCreateRequest request) {

        Quiz quiz = Quiz.builder()
                .category(request.getCategory())
                .title(request.getTitle())
                .content(request.getContent())
                .answer(request.getAnswer())
                .build();

        quizRepository.save(quiz);
    }

    // 퀴즈 전체조회(페이징 처리)
    public Page<Quiz> getQuizzes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return quizRepository.findAll(pageable);
    }

    // 퀴즈 조회
    public QuizResponse getQuiz(Long quizId) {

        return QuizResponse.fromEntity(quizRepository.findById(quizId)
                .orElseThrow(() -> CustomException.QUIZ_NOT_FOUND));
    }

    // 정답유무 확인
    public Boolean checkAnswer(QuizCheckAnswerRequest request) {

        Boolean isCorrect = false;

        Quiz quiz = quizRepository.findById(request.getQuizId())
                        .orElseThrow(() -> CustomException.QUIZ_NOT_FOUND);

        // 유저가 입력한 답과 퀴즈 답과 일치시 true 변경
        if(request.getUserAnswer().equals(quiz.getAnswer())) {
            isCorrect = true;
        }

        return isCorrect;
    }
}
