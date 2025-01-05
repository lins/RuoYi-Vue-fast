package com.ruoyi.exam.domain;

import java.math.BigDecimal;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 试卷对象 exam_paper
 * 
 * @author ruoyi
 */
public class ExamPaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 类型编码 */
    @Excel(name = "类型编码")
    private String typeCode;

    /** 试卷名称 */
    @Excel(name = "试卷名称")
    private String name;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year;

    /** 月份 */
    @Excel(name = "月份")
    private Integer month;

    /** 难度等级（1简单 2普通 3困难） */
    @Excel(name = "难度等级", readConverterExp = "1=简单,2=普通,3=困难")
    private String difficulty;

    /** 级别（1-8级） */
    @Excel(name = "级别", readConverterExp = "1=一级,2=二级,3=三级,4=四级,5=五级,6=六级,7=七级,8=八级")
    private Integer level;

    /** 考试时长（分钟） */
    @Excel(name = "考试时长", suffix = "分钟")
    private Integer duration;

    /** 总分 */
    @Excel(name = "总分")
    private BigDecimal totalScore;

    /** 及格分数 */
    @Excel(name = "及格分数")
    private BigDecimal passScore;

    /** 试题数量 */
    @Excel(name = "试题数量")
    private Integer questionCount;

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

    public void setTypeCode(String typeCode) 
    {
        this.typeCode = typeCode;
    }

    public String getTypeCode() 
    {
        return typeCode;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setYear(Integer year) 
    {
        this.year = year;
    }

    public Integer getYear() 
    {
        return year;
    }

    public void setMonth(Integer month) 
    {
        this.month = month;
    }

    public Integer getMonth() 
    {
        return month;
    }

    public void setDifficulty(String difficulty) 
    {
        this.difficulty = difficulty;
    }

    public String getDifficulty() 
    {
        return difficulty;
    }

    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }

    public void setDuration(Integer duration) 
    {
        this.duration = duration;
    }

    public Integer getDuration() 
    {
        return duration;
    }

    public void setTotalScore(BigDecimal totalScore) 
    {
        this.totalScore = totalScore;
    }

    public BigDecimal getTotalScore() 
    {
        return totalScore;
    }

    public void setPassScore(BigDecimal passScore) 
    {
        this.passScore = passScore;
    }

    public BigDecimal getPassScore() 
    {
        return passScore;
    }

    public void setQuestionCount(Integer questionCount) 
    {
        this.questionCount = questionCount;
    }

    public Integer getQuestionCount() 
    {
        return questionCount;
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
            .append("typeCode", getTypeCode())
            .append("name", getName())
            .append("year", getYear())
            .append("month", getMonth())
            .append("difficulty", getDifficulty())
            .append("level", getLevel())
            .append("duration", getDuration())
            .append("totalScore", getTotalScore())
            .append("passScore", getPassScore())
            .append("questionCount", getQuestionCount())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
