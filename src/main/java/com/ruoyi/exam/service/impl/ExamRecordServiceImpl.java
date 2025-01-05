package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamRecordMapper;
import com.ruoyi.exam.domain.ExamRecord;
import com.ruoyi.exam.service.IExamRecordService;

/**
 * 考试记录Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class ExamRecordServiceImpl implements IExamRecordService 
{
    @Autowired
    private ExamRecordMapper examRecordMapper;

    /**
     * 查询考试记录
     * 
     * @param recordId 考试记录主键
     * @return 考试记录
     */
    @Override
    public ExamRecord selectExamRecordByRecordId(Long recordId)
    {
        return examRecordMapper.selectExamRecordByRecordId(recordId);
    }

    /**
     * 查询考试记录列表
     * 
     * @param examRecord 考试记录
     * @return 考试记录
     */
    @Override
    public List<ExamRecord> selectExamRecordList(ExamRecord examRecord)
    {
        return examRecordMapper.selectExamRecordList(examRecord);
    }

    /**
     * 新增考试记录
     * 
     * @param examRecord 考试记录
     * @return 结果
     */
    @Override
    public int insertExamRecord(ExamRecord examRecord)
    {
        return examRecordMapper.insertExamRecord(examRecord);
    }

    /**
     * 修改考试记录
     * 
     * @param examRecord 考试记录
     * @return 结果
     */
    @Override
    public int updateExamRecord(ExamRecord examRecord)
    {
        return examRecordMapper.updateExamRecord(examRecord);
    }

    /**
     * 批量删除考试记录
     * 
     * @param recordIds 需要删除的考试记录主键
     * @return 结果
     */
    @Override
    public int deleteExamRecordByRecordIds(Long[] recordIds)
    {
        return examRecordMapper.deleteExamRecordByRecordIds(recordIds);
    }

    /**
     * 删除考试记录信息
     * 
     * @param recordId 考试记录主键
     * @return 结果
     */
    @Override
    public int deleteExamRecordByRecordId(Long recordId)
    {
        return examRecordMapper.deleteExamRecordByRecordId(recordId);
    }
}
