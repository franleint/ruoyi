package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TBookBorrow;

/**
 * 借阅记录Mapper接口
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public interface TBookBorrowMapper 
{
    /**
     * 查询借阅记录
     * 
     * @param borrowId 借阅记录主键
     * @return 借阅记录
     */
    public TBookBorrow selectTBookBorrowByBorrowId(Long borrowId);

    /**
     * 查询借阅记录列表
     * 
     * @param tBookBorrow 借阅记录
     * @return 借阅记录集合
     */
    public List<TBookBorrow> selectTBookBorrowList(TBookBorrow tBookBorrow);

    /**
     * 新增借阅记录
     * 
     * @param tBookBorrow 借阅记录
     * @return 结果
     */
    public int insertTBookBorrow(TBookBorrow tBookBorrow);

    /**
     * 修改借阅记录
     * 
     * @param tBookBorrow 借阅记录
     * @return 结果
     */
    public int updateTBookBorrow(TBookBorrow tBookBorrow);

    /**
     * 删除借阅记录
     * 
     * @param borrowId 借阅记录主键
     * @return 结果
     */
    public int deleteTBookBorrowByBorrowId(Long borrowId);

    /**
     * 批量删除借阅记录
     * 
     * @param borrowIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBookBorrowByBorrowIds(Long[] borrowIds);
}
