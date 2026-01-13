package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TLibraryAreaMapper;
import com.ruoyi.system.domain.TLibraryArea;
import com.ruoyi.system.service.ITLibraryAreaService;

/**
 * 馆藏区域Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
@Service
public class TLibraryAreaServiceImpl implements ITLibraryAreaService 
{
    @Autowired
    private TLibraryAreaMapper tLibraryAreaMapper;

    /**
     * 查询馆藏区域
     * 
     * @param areaId 馆藏区域主键
     * @return 馆藏区域
     */
    @Override
    public TLibraryArea selectTLibraryAreaByAreaId(Long areaId)
    {
        return tLibraryAreaMapper.selectTLibraryAreaByAreaId(areaId);
    }

    /**
     * 查询馆藏区域列表
     * 
     * @param tLibraryArea 馆藏区域
     * @return 馆藏区域
     */
    @Override
    public List<TLibraryArea> selectTLibraryAreaList(TLibraryArea tLibraryArea)
    {
        return tLibraryAreaMapper.selectTLibraryAreaList(tLibraryArea);
    }

    /**
     * 新增馆藏区域
     * 
     * @param tLibraryArea 馆藏区域
     * @return 结果
     */
    @Override
    public int insertTLibraryArea(TLibraryArea tLibraryArea)
    {
        tLibraryArea.setCreateTime(DateUtils.getNowDate());
        return tLibraryAreaMapper.insertTLibraryArea(tLibraryArea);
    }

    /**
     * 修改馆藏区域
     * 
     * @param tLibraryArea 馆藏区域
     * @return 结果
     */
    @Override
    public int updateTLibraryArea(TLibraryArea tLibraryArea)
    {
        tLibraryArea.setUpdateTime(DateUtils.getNowDate());
        return tLibraryAreaMapper.updateTLibraryArea(tLibraryArea);
    }

    /**
     * 批量删除馆藏区域
     * 
     * @param areaIds 需要删除的馆藏区域主键
     * @return 结果
     */
    @Override
    public int deleteTLibraryAreaByAreaIds(Long[] areaIds)
    {
        return tLibraryAreaMapper.deleteTLibraryAreaByAreaIds(areaIds);
    }

    /**
     * 删除馆藏区域信息
     * 
     * @param areaId 馆藏区域主键
     * @return 结果
     */
    @Override
    public int deleteTLibraryAreaByAreaId(Long areaId)
    {
        return tLibraryAreaMapper.deleteTLibraryAreaByAreaId(areaId);
    }
}
