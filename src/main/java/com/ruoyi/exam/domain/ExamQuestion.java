package com.ruoyi.exam.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
/**
 * 试题对象 exam_question
 */
public class ExamQuestion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 试题ID */
    private Long id;

    /** 试卷ID */
    @Excel(name = "试卷ID")
    private Long paperId;

    /** 题目类型（1单选 2多选 3判断 4填空 5编程） */
    @Excel(name = "题目类型", readConverterExp = "1=单选,2=多选,3=判断,4=填空,5=编程")
    private String questionType;

    /** 题目分数 */
    @Excel(name = "题目分数")
    private Long questionScore;

    /** 题目内容 */
    @Excel(name = "题目内容")
    private String questionText;

    /** 选项A */
    @Excel(name = "选项A")
    private String optionA;

    /** 选项B */
    @Excel(name = "选项B")
    private String optionB;

    /** 选项C */
    @Excel(name = "选项C")
    private String optionC;

    /** 选项D */
    @Excel(name = "选项D")
    private String optionD;

    /** 正确答案 */
    @Excel(name = "正确答案")
    private String correctAnswer;

    /** 题目解析 */
    @Excel(name = "题目解析")
    private String analysis;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long sortOrder;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPaperId(Long paperId) 
    {
        this.paperId = paperId;
    }

    public Long getPaperId() 
    {
        return paperId;
    }
    public void setQuestionType(String questionType) 
    {
        this.questionType = questionType;
    }

    public String getQuestionType() 
    {
        return questionType;
    }
    public void setQuestionScore(Long questionScore) 
    {
        this.questionScore = questionScore;
    }

    public Long getQuestionScore() 
    {
        return questionScore;
    }
    public void setQuestionText(String questionText) 
    {
        this.questionText = questionText;
    }

    public String getQuestionText() 
    {
        return questionText;
    }
    public void setOptionA(String optionA) 
    {
        this.optionA = optionA;
    }

    public String getOptionA() 
    {
        return optionA;
    }
    public void setOptionB(String optionB) 
    {
        this.optionB = optionB;
    }

    public String getOptionB() 
    {
        return optionB;
    }
    public void setOptionC(String optionC) 
    {
        this.optionC = optionC;
    }

    public String getOptionC() 
    {
        return optionC;
    }
    public void setOptionD(String optionD) 
    {
        this.optionD = optionD;
    }

    public String getOptionD() 
    {
        return optionD;
    }
    public void setCorrectAnswer(String correctAnswer) 
    {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() 
    {
        return correctAnswer;
    }
    public void setAnalysis(String analysis) 
    {
        this.analysis = analysis;
    }

    public String getAnalysis() 
    {
        return analysis;
    }
    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
    {
        return sortOrder;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("paperId", getPaperId())
            .append("questionType", getQuestionType())
            .append("questionScore", getQuestionScore())
            .append("questionText", getQuestionText())
            .append("optionA", getOptionA())
            .append("optionB", getOptionB())
            .append("optionC", getOptionC())
            .append("optionD", getOptionD())
            .append("correctAnswer", getCorrectAnswer())
            .append("analysis", getAnalysis())
            .append("sortOrder", getSortOrder())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
