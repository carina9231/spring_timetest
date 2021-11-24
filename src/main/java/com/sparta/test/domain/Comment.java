package com.sparta.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.test.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="question_idx", nullable = false)
    private Question question;

    public Comment(CommentRequestDto requestDto, Question question) {
        this.comment = requestDto.getComment();
        this.question = question;
    }

}
