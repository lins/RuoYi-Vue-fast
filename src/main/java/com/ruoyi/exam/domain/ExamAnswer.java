package com.ruoyi.exam.domain;

import java.math.BigDecimal;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 考试答题对象 exam_answer
 */
public class ExamAnswer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 答题ID */
    private Long id;

    /** 考试记录ID */
    @Excel(name = "考试记录ID")
    private Long recordId;

    /** 试题ID */
    @Excel(name = "试题ID")
    private Long questionId;

    /** 用户答案 */
    @Excel(name = "用户答案")
    private String userAnswer;

    /** 是否正确（0错误 1正确） */
    @Excel(name = "是否正确", readConverterExp = "0=错误,1=正确")
    private String isCorrect;

    /** 得分 */
    @Excel(name = "得分")
    private BigDecimal score;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }

    public void setQuestionId(Long questionId) 
    {
        this.questionId = questionId;
    }

    public Long getQuestionId() 
    {
        return questionId;
    }

    public void setUserAnswer(String userAnswer) 
    {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() 
    {
        return userAnswer;
    }

    public void setIsCorrect(String isCorrect) 
    {
        this.isCorrect = isCorrect;
    }

    public String getIsCorrect() 
    {
        return isCorrect;
    }

    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }
}
