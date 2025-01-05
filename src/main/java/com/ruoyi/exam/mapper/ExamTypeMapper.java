package com.ruoyi.exam.mapper;

import java.util.List;
import com.ruoyi.exam.domain.ExamType;

/**
 * 考试类型Mapper接口
 * 
 * @author ruoyi
 */
public interface ExamTypeMapper 
{
    /**
     * 查询考试类型
     * 
     * @param typeId 考试类型主键
     * @return 考试类型
     */
    public ExamType selectExamTypeByTypeId(Long typeId);

    /**
     * 根据类型编码查询考试类型
     * 
     * @param typeCode 类型编码
     * @return 考试类型
     */
    public ExamType selectExamTypeByTypeCode(String typeCode);

    /**
     * 查询考试类型列表
     * 
     * @param examType 考试类型
     * @return 考试类型集合
     */
    public List<ExamType> selectExamTypeList(ExamType examType);

    /**
     * 新增考试类型
     * 
     * @param examType 考试类型
     * @return 结果
     */
    public int insertExamType(ExamType examType);

    /**
     * 修改考试类型
     * 
     * @param examType 考试类型
     * @return 结果
     */
    public int updateExamType(ExamType examType);

    /**
     * 删除考试类型
     * 
     * @param typeId 考试类型主键
     * @return 结果
     */
    public int deleteExamTypeByTypeId(Long typeId);

    /**
     * 批量删除考试类型
     * 
     * @param typeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamTypeByTypeIds(Long[] typeIds);
}
