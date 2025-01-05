package com.ruoyi.exam.mapper;

import java.util.List;
import com.ruoyi.exam.domain.ExamPaper;

/**
 * 试卷Mapper接口
 * 
 * @author ruoyi
 */
public interface ExamPaperMapper 
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
     * 删除试卷
     * 
     * @param paperId 试卷主键
     * @return 结果
     */
    public int deleteExamPaperByPaperId(Long paperId);

    /**
     * 批量删除试卷
     * 
     * @param paperIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamPaperByPaperIds(Long[] paperIds);
}
