package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamQuestionMapper;
import com.ruoyi.exam.domain.ExamQuestion;
import com.ruoyi.exam.service.IExamQuestionService;

/**
 * 试题Service业务层处理
 */
@Service
public class ExamQuestionServiceImpl implements IExamQuestionService 
{
    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    /**
     * 查询试题列表
     */
    @Override
    public List<ExamQuestion> selectExamQuestionList(ExamQuestion examQuestion)
    {
        return examQuestionMapper.selectExamQuestionList(examQuestion);
    }

    /**
     * 查询试题
     */
    @Override
    public ExamQuestion selectExamQuestionById(Long id)
    {
        return examQuestionMapper.selectExamQuestionById(id);
    }

    /**
     * 查询试卷的试题列表
     */
    @Override
    public List<ExamQuestion> selectExamQuestionByPaperId(Long paperId)
    {
        return examQuestionMapper.selectExamQuestionByPaperId(paperId);
    }

    /**
     * 新增试题
     */
    @Override
    public int insertExamQuestion(ExamQuestion examQuestion)
    {
        return examQuestionMapper.insertExamQuestion(examQuestion);
    }

    /**
     * 修改试题
     */
    @Override
    public int updateExamQuestion(ExamQuestion examQuestion)
    {
        return examQuestionMapper.updateExamQuestion(examQuestion);
    }

    /**
     * 批量删除试题
     */
    @Override
    public int deleteExamQuestionByIds(Long[] ids)
    {
        return examQuestionMapper.deleteExamQuestionByIds(ids);
    }

    /**
     * 删除试题信息
     */
    @Override
    public int deleteExamQuestionById(Long id)
    {
        return examQuestionMapper.deleteExamQuestionById(id);
    }
}
