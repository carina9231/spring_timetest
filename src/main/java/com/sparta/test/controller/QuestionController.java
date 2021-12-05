package com.sparta.test.controller;

import com.sparta.test.domain.Question;
import com.sparta.test.dto.CommentRequestDto;
import com.sparta.test.dto.QuestionRequestDto;
import com.sparta.test.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/question")
    public Question setQuestion(@RequestBody QuestionRequestDto questionsRequestDto) {
        // 응답 보내기
        return questionService.setQuestion(questionsRequestDto);
    }

    @GetMapping("/questions")//전체 보기
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/question/{id}")//상세보기
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @PostMapping("/question/comment")
    public void setComment(@RequestBody CommentRequestDto commentRequestDto) {
        // 응답 보내기
        questionService.setComment(commentRequestDto);
    }

    @PutMapping("/question/{id}")
    public Long update(@PathVariable Long id, @RequestBody QuestionRequestDto requestDto) {
        questionService.update(id, requestDto);
        return id;
    }
}