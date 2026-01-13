package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TLibraryArea;

/**
 * 馆藏区域Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public interface TLibraryAreaMapper 
{
    /**
     * 查询馆藏区域
     * 
     * @param areaId 馆藏区域主键
     * @return 馆藏区域
     */
    public TLibraryArea selectTLibraryAreaByAreaId(Long areaId);

    /**
     * 查询馆藏区域列表
     * 
     * @param tLibraryArea 馆藏区域
     * @return 馆藏区域集合
     */
    public List<TLibraryArea> selectTLibraryAreaList(TLibraryArea tLibraryArea);

    /**
     * 新增馆藏区域
     * 
     * @param tLibraryArea 馆藏区域
     * @return 结果
     */
    public int insertTLibraryArea(TLibraryArea tLibraryArea);

    /**
     * 修改馆藏区域
     * 
     * @param tLibraryArea 馆藏区域
     * @return 结果
     */
    public int updateTLibraryArea(TLibraryArea tLibraryArea);

    /**
     * 删除馆藏区域
     * 
     * @param areaId 馆藏区域主键
     * @return 结果
     */
    public int deleteTLibraryAreaByAreaId(Long areaId);

    /**
     * 批量删除馆藏区域
     * 
     * @param areaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTLibraryAreaByAreaIds(Long[] areaIds);
}
