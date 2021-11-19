package com.sparta.test.repository;

import com.sparta.test.domain.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findAllByOrderByModifiedAtDesc();
}
