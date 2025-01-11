package com.ruoyi.exam.mapper;

import java.util.List;
import com.ruoyi.exam.domain.ExamAnswer;

/**
 * 考试答题Mapper接口
 */
public interface ExamAnswerMapper 
{
    /**
     * 查询考试答题列表
     */
    public List<ExamAnswer> selectExamAnswerList(ExamAnswer examAnswer);

    /**
     * 查询考试答题
     */
    public ExamAnswer selectExamAnswerById(Long id);

    /**
     * 新增考试答题
     */
    public int insertExamAnswer(ExamAnswer examAnswer);

    /**
     * 修改考试答题
     */
    public int updateExamAnswer(ExamAnswer examAnswer);

    /**
     * 删除考试答题
     */
    public int deleteExamAnswerById(Long id);

    /**
     * 批量删除考试答题
     */
    public int deleteExamAnswerByIds(Long[] ids);
}
