package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBookBorrowMapper;
import com.ruoyi.system.domain.TBookBorrow;
import com.ruoyi.system.service.ITBookBorrowService;

/**
 * 借阅记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
@Service
public class TBookBorrowServiceImpl implements ITBookBorrowService 
{
    @Autowired
    private TBookBorrowMapper tBookBorrowMapper;

    /**
     * 查询借阅记录
     * 
     * @param borrowId 借阅记录主键
     * @return 借阅记录
     */
    @Override
    public TBookBorrow selectTBookBorrowByBorrowId(Long borrowId)
    {
        return tBookBorrowMapper.selectTBookBorrowByBorrowId(borrowId);
    }

    /**
     * 查询借阅记录列表
     * 
     * @param tBookBorrow 借阅记录
     * @return 借阅记录
     */
    @Override
    public List<TBookBorrow> selectTBookBorrowList(TBookBorrow tBookBorrow)
    {
        return tBookBorrowMapper.selectTBookBorrowList(tBookBorrow);
    }

    /**
     * 新增借阅记录
     * 
     * @param tBookBorrow 借阅记录
     * @return 结果
     */
    @Override
    public int insertTBookBorrow(TBookBorrow tBookBorrow)
    {
        tBookBorrow.setCreateTime(DateUtils.getNowDate());
        return tBookBorrowMapper.insertTBookBorrow(tBookBorrow);
    }

    /**
     * 修改借阅记录
     * 
     * @param tBookBorrow 借阅记录
     * @return 结果
     */
    @Override
    public int updateTBookBorrow(TBookBorrow tBookBorrow)
    {
        tBookBorrow.setUpdateTime(DateUtils.getNowDate());
        return tBookBorrowMapper.updateTBookBorrow(tBookBorrow);
    }

    /**
     * 批量删除借阅记录
     * 
     * @param borrowIds 需要删除的借阅记录主键
     * @return 结果
     */
    @Override
    public int deleteTBookBorrowByBorrowIds(Long[] borrowIds)
    {
        return tBookBorrowMapper.deleteTBookBorrowByBorrowIds(borrowIds);
    }

    /**
     * 删除借阅记录信息
     * 
     * @param borrowId 借阅记录主键
     * @return 结果
     */
    @Override
    public int deleteTBookBorrowByBorrowId(Long borrowId)
    {
        return tBookBorrowMapper.deleteTBookBorrowByBorrowId(borrowId);
    }
}
