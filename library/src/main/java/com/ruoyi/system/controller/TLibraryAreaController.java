package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.TLibraryArea;
import com.ruoyi.system.service.ITLibraryAreaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 馆藏区域Controller
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
@RestController
@RequestMapping("/system/area")
public class TLibraryAreaController extends BaseController
{
    @Autowired
    private ITLibraryAreaService tLibraryAreaService;

    /**
     * 查询馆藏区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(TLibraryArea tLibraryArea)
    {
        startPage();
        List<TLibraryArea> list = tLibraryAreaService.selectTLibraryAreaList(tLibraryArea);
        return getDataTable(list);
    }

    /**
     * 导出馆藏区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area:export')")
    @Log(title = "馆藏区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TLibraryArea tLibraryArea)
    {
        List<TLibraryArea> list = tLibraryAreaService.selectTLibraryAreaList(tLibraryArea);
        ExcelUtil<TLibraryArea> util = new ExcelUtil<TLibraryArea>(TLibraryArea.class);
        util.exportExcel(response, list, "馆藏区域数据");
    }

    /**
     * 获取馆藏区域详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:area:query')")
    @GetMapping(value = "/{areaId}")
    public AjaxResult getInfo(@PathVariable("areaId") Long areaId)
    {
        return success(tLibraryAreaService.selectTLibraryAreaByAreaId(areaId));
    }

    /**
     * 新增馆藏区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:add')")
    @Log(title = "馆藏区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TLibraryArea tLibraryArea)
    {
        return toAjax(tLibraryAreaService.insertTLibraryArea(tLibraryArea));
    }

    /**
     * 修改馆藏区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:edit')")
    @Log(title = "馆藏区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TLibraryArea tLibraryArea)
    {
        return toAjax(tLibraryAreaService.updateTLibraryArea(tLibraryArea));
    }

    /**
     * 删除馆藏区域
     */
    @PreAuthorize("@ss.hasPermi('system:area:remove')")
    @Log(title = "馆藏区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{areaIds}")
    public AjaxResult remove(@PathVariable Long[] areaIds)
    {
        return toAjax(tLibraryAreaService.deleteTLibraryAreaByAreaIds(areaIds));
    }
}
