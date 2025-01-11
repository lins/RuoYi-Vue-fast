package com.ruoyi.exam.service.impl;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamRecordMapper;
import com.ruoyi.exam.mapper.ExamAnswerMapper;
import com.ruoyi.exam.domain.ExamRecord;
import com.ruoyi.exam.domain.ExamAnswer;
import com.ruoyi.exam.domain.ExamQuestion;
import com.ruoyi.exam.service.IExamRecordService;
import com.ruoyi.exam.service.IExamQuestionService;
import com.ruoyi.exam.dto.ExamSubmitDTO;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;

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

    @Autowired
    private IExamQuestionService examQuestionService;

    @Autowired
    private ExamAnswerMapper examAnswerMapper;

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

    @Override
    public ExamRecord submitExam(ExamSubmitDTO examSubmit) {
        // 获取当前用户
        Long userId = SecurityUtils.getUserId();

        // 创建考试记录
        ExamRecord record = new ExamRecord();
        record.setUserId(userId);
        record.setPaperId(examSubmit.getPaperId());
        record.setStartTime(DateUtils.addSeconds(new Date(), -examSubmit.getDuration().intValue()));
        record.setEndTime(new Date());
        record.setStatus("1"); // 已完成

        // 计算得分
        BigDecimal totalScore = BigDecimal.ZERO;
        for (ExamSubmitDTO.AnswerDTO answer : examSubmit.getAnswers()) {
            ExamQuestion question = examQuestionService.selectExamQuestionById(answer.getQuestionId());
            if (question != null && question.getCorrectAnswer().equals(answer.getUserAnswer())) {
                totalScore = totalScore.add(new BigDecimal(question.getQuestionScore()));
            }
        }
        record.setScore(totalScore);

        // 保存考试记录
        examRecordMapper.insertExamRecord(record);

        // 保存答题记录
        for (ExamSubmitDTO.AnswerDTO answer : examSubmit.getAnswers()) {
            ExamAnswer examAnswer = new ExamAnswer();
            examAnswer.setRecordId(record.getId());
            examAnswer.setQuestionId(answer.getQuestionId());
            examAnswer.setUserAnswer(answer.getUserAnswer());

            ExamQuestion question = examQuestionService.selectExamQuestionById(answer.getQuestionId());
            if (question != null) {
                examAnswer.setIsCorrect(question.getCorrectAnswer().equals(answer.getUserAnswer()) ? "1" : "0");
                if (examAnswer.getIsCorrect().equals("1")) {
                    examAnswer.setScore(new BigDecimal(question.getQuestionScore()));
                } else {
                    examAnswer.setScore(BigDecimal.ZERO);
                }
            }

            examAnswerMapper.insertExamAnswer(examAnswer);
        }

        return record;
    }
}
