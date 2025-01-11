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
import com.ruoyi.exam.domain.ExamQuestion;
import com.ruoyi.exam.service.IExamQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 试题Controller
 */
@RestController
@RequestMapping("/exam/question")
public class ExamQuestionController extends BaseController
{
    @Autowired
    private IExamQuestionService examQuestionService;

    /**
     * 查询试题列表
     */
    @PreAuthorize("@ss.hasPermi('exam:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamQuestion examQuestion)
    {
        startPage();
        List<ExamQuestion> list = examQuestionService.selectExamQuestionList(examQuestion);
        return getDataTable(list);
    }

    /**
     * 获取试题详细信息
     */
    @PreAuthorize("@ss.hasPermi('exam:question:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examQuestionService.selectExamQuestionById(id));
    }

    /**
     * 获取试卷的试题列表
     */
    @GetMapping(value = "/paper/{paperId}")
    public AjaxResult getQuestionsByPaperId(@PathVariable("paperId") Long paperId)
    {
        return success(examQuestionService.selectExamQuestionByPaperId(paperId));
    }

    /**
     * 新增试题
     */
    @PreAuthorize("@ss.hasPermi('exam:question:add')")
    @Log(title = "试题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamQuestion examQuestion)
    {
        return toAjax(examQuestionService.insertExamQuestion(examQuestion));
    }

    /**
     * 修改试题
     */
    @PreAuthorize("@ss.hasPermi('exam:question:edit')")
    @Log(title = "试题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamQuestion examQuestion)
    {
        return toAjax(examQuestionService.updateExamQuestion(examQuestion));
    }

    /**
     * 删除试题
     */
    @PreAuthorize("@ss.hasPermi('exam:question:remove')")
    @Log(title = "试题管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examQuestionService.deleteExamQuestionByIds(ids));
    }
}
