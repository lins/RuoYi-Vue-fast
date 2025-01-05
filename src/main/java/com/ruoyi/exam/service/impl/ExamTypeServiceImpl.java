package com.ruoyi.exam.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.exam.mapper.ExamTypeMapper;
import com.ruoyi.exam.domain.ExamType;
import com.ruoyi.exam.service.IExamTypeService;

/**
 * 考试类型Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class ExamTypeServiceImpl implements IExamTypeService 
{
    @Autowired
    private ExamTypeMapper examTypeMapper;

    /**
     * 查询考试类型
     * 
     * @param typeId 考试类型主键
     * @return 考试类型
     */
    @Override
    public ExamType selectExamTypeByTypeId(Long typeId)
    {
        return examTypeMapper.selectExamTypeByTypeId(typeId);
    }

    /**
     * 根据类型编码查询考试类型
     * 
     * @param typeCode 类型编码
     * @return 考试类型
     */
    @Override
    public ExamType selectExamTypeByTypeCode(String typeCode)
    {
        return examTypeMapper.selectExamTypeByTypeCode(typeCode);
    }

    /**
     * 查询考试类型列表
     * 
     * @param examType 考试类型
     * @return 考试类型
     */
    @Override
    public List<ExamType> selectExamTypeList(ExamType examType)
    {
        return examTypeMapper.selectExamTypeList(examType);
    }

    /**
     * 新增考试类型
     * 
     * @param examType 考试类型
     * @return 结果
     */
    @Override
    public int insertExamType(ExamType examType)
    {
        return examTypeMapper.insertExamType(examType);
    }

    /**
     * 修改考试类型
     * 
     * @param examType 考试类型
     * @return 结果
     */
    @Override
    public int updateExamType(ExamType examType)
    {
        return examTypeMapper.updateExamType(examType);
    }

    /**
     * 批量删除考试类型
     * 
     * @param typeIds 需要删除的考试类型主键
     * @return 结果
     */
    @Override
    public int deleteExamTypeByTypeIds(Long[] typeIds)
    {
        return examTypeMapper.deleteExamTypeByTypeIds(typeIds);
    }

    /**
     * 删除考试类型信息
     * 
     * @param typeId 考试类型主键
     * @return 结果
     */
    @Override
    public int deleteExamTypeByTypeId(Long typeId)
    {
        return examTypeMapper.deleteExamTypeByTypeId(typeId);
    }
}
