package com.ruoyi.exam.service;

import java.util.List;
import com.ruoyi.exam.domain.ExamPaper;

/**
 * 试卷Service接口
 * 
 * @author ruoyi
 */
public interface IExamPaperService 
{
    /**
     * 查询试卷
     * 
     * @param paperId 试卷主键
     * @return 试卷
     */
    public ExamPaper selectExamPaperByPaperId(Long paperId);

    /**
     * 查询试卷列表
     * 
     * @param examPaper 试卷
     * @return 试卷集合
     */
    public List<ExamPaper> selectExamPaperList(ExamPaper examPaper);

    /**
     * 新增试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    public int insertExamPaper(ExamPaper examPaper);

    /**
     * 修改试卷
     * 
     * @param examPaper 试卷
     * @return 结果
     */
    public int updateExamPaper(ExamPaper examPaper);

    /**
     * 批量删除试卷
     * 
     * @param paperIds 需要删除的试卷主键集合
     * @return 结果
     */
    public int deleteExamPaperByPaperIds(Long[] paperIds);

    /**
     * 删除试卷信息
     * 
     * @param paperId 试卷主键
     * @return 结果
     */
    public int deleteExamPaperByPaperId(Long paperId);
}
