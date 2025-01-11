package com.ruoyi.exam.mapper;

import java.util.List;
import com.ruoyi.exam.domain.ExamQuestion;

/**
 * 试题Mapper接口
 */
public interface ExamQuestionMapper 
{
    /**
     * 查询试题列表
     */
    public List<ExamQuestion> selectExamQuestionList(ExamQuestion examQuestion);

    /**
     * 查询试题
     */
    public ExamQuestion selectExamQuestionById(Long id);

    /**
     * 查询试卷的试题列表
     */
    public List<ExamQuestion> selectExamQuestionByPaperId(Long paperId);

    /**
     * 新增试题
     */
    public int insertExamQuestion(ExamQuestion examQuestion);

    /**
     * 修改试题
     */
    public int updateExamQuestion(ExamQuestion examQuestion);

    /**
     * 删除试题
     */
    public int deleteExamQuestionById(Long id);

    /**
     * 批量删除试题
     */
    public int deleteExamQuestionByIds(Long[] ids);
}