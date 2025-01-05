package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamPaperMapper;
import com.ruoyi.exam.domain.ExamPaper;
import com.ruoyi.exam.service.IExamPaperService;

/**
 * 试卷Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class ExamPaperServiceImpl implements IExamPaperService 
{
    @Autowired
    private ExamPaperMapper examPaperMapper;

    /**
     * 查询试卷
     * 
     * @param paperId 试卷主键
     * @return 试卷
     */
    @Override
    public ExamPaper selectExamPaperByPaperId(Long paperId)
    {
        return examPaperMapper.selectExamPaperByPaperId(paperId);
    }

    /**
     * 查询试卷列表
     * 
     * @param examPaper 试卷
     * @return 试卷
     */
    @Override
    public List<ExamPaper> selectExamPaperList(ExamPaper examPaper)
    {
        return examPaperMapper.selectExamPaperList(examPaper);
    }

    /**
     * 新增试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    @Override
    public int insertExamPaper(ExamPaper examPaper)
    {
        return examPaperMapper.insertExamPaper(examPaper);
    }

    /**
     * 修改试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    @Override
    public int updateExamPaper(ExamPaper examPaper)
    {
        return examPaperMapper.updateExamPaper(examPaper);
    }

    /**
     * 批量删除试卷
     * 
     * @param paperIds 需要删除的试卷主键数组
     * @return 结果
     */
    @Override
    public int deleteExamPaperByPaperIds(Long[] paperIds)
    {
        return examPaperMapper.deleteExamPaperByPaperIds(paperIds);
    }

    /**
     * 删除试卷信息
     * 
     * @param paperId 试卷主键
     * @return 结果
     */
    @Override
    public int deleteExamPaperByPaperId(Long paperId)
    {
        return examPaperMapper.deleteExamPaperByPaperId(paperId);
    }
}
