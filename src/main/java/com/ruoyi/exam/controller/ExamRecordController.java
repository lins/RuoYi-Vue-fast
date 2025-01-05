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
import com.ruoyi.exam.domain.ExamRecord;
import com.ruoyi.exam.service.IExamRecordService;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 考试记录Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/exam/record")
public class ExamRecordController extends BaseController
{
    @Autowired
    private IExamRecordService examRecordService;

    /**
     * 查询考试记录列表
     */
    @PreAuthorize("@ss.hasPermi('exam:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamRecord examRecord)
    {
        startPage();
        List<ExamRecord> list = examRecordService.selectExamRecordList(examRecord);
        return getDataTable(list);
    }

    /**
     * 获取考试记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(examRecordService.selectExamRecordByRecordId(recordId));
    }

    /**
     * 新增考试记录
     */
    @PreAuthorize("@ss.hasPermi('exam:record:add')")
    @Log(title = "考试记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamRecord examRecord)
    {
        return toAjax(examRecordService.insertExamRecord(examRecord));
    }

    /**
     * 修改考试记录
     */
    @PreAuthorize("@ss.hasPermi('exam:record:edit')")
    @Log(title = "考试记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamRecord examRecord)
    {
        return toAjax(examRecordService.updateExamRecord(examRecord));
    }

    /**
     * 删除考试记录
     */
    @PreAuthorize("@ss.hasPermi('exam:record:remove')")
    @Log(title = "考试记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(examRecordService.deleteExamRecordByRecordIds(recordIds));
    }
}
