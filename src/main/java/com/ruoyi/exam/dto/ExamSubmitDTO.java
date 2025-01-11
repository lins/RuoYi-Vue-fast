package com.ruoyi.exam.dto;

import java.util.List;

/**
 * 提交考试DTO
 */
public class ExamSubmitDTO {
    /** 试卷ID */
    private Long paperId;

    /** 考试时长（秒） */
    private Long duration;

    /** 答题列表 */
    private List<AnswerDTO> answers;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    /**
     * 答题DTO
     */
    public static class AnswerDTO {
        /** 试题ID */
        private Long questionId;

        /** 用户答案 */
        private String userAnswer;

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public String getUserAnswer() {
            return userAnswer;
        }

        public void setUserAnswer(String userAnswer) {
            this.userAnswer = userAnswer;
        }
    }
}
