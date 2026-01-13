package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DictUtils;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TBook;
import com.ruoyi.system.service.ITBookService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图书信息Controller
 * 
 * @author ruoyi
 * @date 2026-01-12
 */
@RestController
@RequestMapping("/system/book")
public class TBookController extends BaseController
{
    @Autowired
    private ITBookService tBookService;

    /**
     * 查询图书信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBook tBook)
    {
        startPage();
        List<TBook> list = tBookService.selectTBookList(tBook);
        return getDataTable(list);
    }

    /**
     * 导出图书信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:export')")
    @Log(title = "图书信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBook tBook)
    {
        List<TBook> list = tBookService.selectTBookList(tBook);
        ExcelUtil<TBook> util = new ExcelUtil<TBook>(TBook.class);
        util.exportExcel(response, list, "图书信息数据");
    }

    /**
     * 获取图书信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return success(tBookService.selectTBookByBookId(bookId));
    }

    /**
     * 新增图书信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:add')")
    @Log(title = "图书信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBook tBook)
    {
        return toAjax(tBookService.insertTBook(tBook));
    }

    /**
     * 修改图书信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:edit')")
    @Log(title = "图书信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBook tBook)
    {
        if(tBook.getBorrowerId() == null && tBook.getStatus().equals(DictUtils.getDictValue("borrow_status","借出"))){
            tBook.setBorrowerId(getUserId());
        }
        return toAjax(tBookService.updateTBook(tBook));
    }

    /**
     * 删除图书信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:remove')")
    @Log(title = "图书信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(tBookService.deleteTBookByBookIds(bookIds));
    }
}
