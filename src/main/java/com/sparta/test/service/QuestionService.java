package com.sparta.test.service;

import com.sparta.test.domain.Comment;
import com.sparta.test.domain.Question;
import com.sparta.test.dto.CommentRequestDto;
import com.sparta.test.dto.QuestionRequestDto;
import com.sparta.test.repository.CommentRepository;
import com.sparta.test.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final CommentRepository commentRepository;

    public Question setQuestion(QuestionRequestDto questionRequestDto) {
        Question question = new Question(questionRequestDto);
        questionRepository.save(question);
        return question;
    }

    public Question getQuestion(Long id){
        return questionRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    @Transactional
    public void setComment(CommentRequestDto commentRequestDto) {
        Question question = questionRepository.findById(commentRequestDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        Comment comment = new Comment(commentRequestDto, question);
        commentRepository.save(comment);
    }
}
