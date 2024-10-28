package com.project.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.SbpApplication;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest(classes = SbpApplication.class)  // 명시적으로 SbpApplication을 설정 클래스로 지정
class SbpApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Transactional
    @Commit
    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
}
