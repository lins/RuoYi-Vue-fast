package com.ruoyi.exam.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.exam.domain.ExamType;
import com.ruoyi.exam.service.IExamTypeService;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 考试类型Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/exam/type")
public class ExamTypeController extends BaseController
{
    @Autowired
    private IExamTypeService examTypeService;

    /**
     * 查询考试类型列表
     */
    @PreAuthorize("@ss.hasPermi('exam:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamType examType)
    {
        startPage();
        List<ExamType> list = examTypeService.selectExamTypeList(examType);
        return getDataTable(list);
    }

    /**
     * 获取考试类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:type:query')")
    @GetMapping(value = "/{typeId}")
    public AjaxResult getInfo(@PathVariable("typeId") Long typeId)
    {
        return success(examTypeService.selectExamTypeByTypeId(typeId));
    }

    /**
     * 获取考试类型详细信息（根据类型编码）
     */
    @PreAuthorize("@ss.hasPermi('exam:type:query')")
    @GetMapping(value = "/code/{typeCode}")
    public AjaxResult getInfoByTypeCode(@PathVariable("typeCode") String typeCode)
    {
        return success(examTypeService.selectExamTypeByTypeCode(typeCode));
    }

    /**
     * 新增考试类型
     */
    @PreAuthorize("@ss.hasPermi('exam:type:add')")
    @Log(title = "考试类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamType examType)
    {
        return toAjax(examTypeService.insertExamType(examType));
    }

    /**
     * 修改考试类型
     */
    @PreAuthorize("@ss.hasPermi('exam:type:edit')")
    @Log(title = "考试类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamType examType)
    {
        return toAjax(examTypeService.updateExamType(examType));
    }

    /**
     * 删除考试类型
     */
    @PreAuthorize("@ss.hasPermi('exam:type:remove')")
    @Log(title = "考试类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeIds}")
    public AjaxResult remove(@PathVariable Long[] typeIds)
    {
        return toAjax(examTypeService.deleteExamTypeByTypeIds(typeIds));
    }
}
