package com.sparta.test.controller;

import com.sparta.test.domain.Questions;
import com.sparta.test.dto.QuestionsDto;
import com.sparta.test.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class QuestionsController {

    private final QuestionsRepository questionsRepository;

    @PostMapping("/api/questions")
    public Questions createQuestions(@RequestBody QuestionsDto requestDto) {
        Questions questions = new Questions(requestDto);
        // 응답 보내기
        return questionsRepository.save(questions);
    }

    @GetMapping("/api/questions")
    public List<Questions> getQuestions() {

        return questionsRepository.findAllByOrderByModifiedAtDesc();
    }
}