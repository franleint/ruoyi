package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBookMapper;
import com.ruoyi.system.domain.TBook;
import com.ruoyi.system.service.ITBookService;

/**
 * 图书信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-01-12
 */
@Service
public class TBookServiceImpl implements ITBookService 
{
    @Autowired
    private TBookMapper tBookMapper;

    /**
     * 查询图书信息
     * 
     * @param bookId 图书信息主键
     * @return 图书信息
     */
    @Override
    public TBook selectTBookByBookId(Long bookId)
    {
        return tBookMapper.selectTBookByBookId(bookId);
    }

    /**
     * 查询图书信息列表
     * 
     * @param tBook 图书信息
     * @return 图书信息
     */
    @Override
    public List<TBook> selectTBookList(TBook tBook)
    {
        return tBookMapper.selectTBookList(tBook);
    }

    /**
     * 新增图书信息
     * 
     * @param tBook 图书信息
     * @return 结果
     */
    @Override
    public int insertTBook(TBook tBook)
    {
        tBook.setCreateTime(DateUtils.getNowDate());
        return tBookMapper.insertTBook(tBook);
    }

    /**
     * 修改图书信息
     * 
     * @param tBook 图书信息
     * @return 结果
     */
    @Override
    public int updateTBook(TBook tBook)
    {
        tBook.setUpdateTime(DateUtils.getNowDate());
        return tBookMapper.updateTBook(tBook);
    }

    /**
     * 批量删除图书信息
     * 
     * @param bookIds 需要删除的图书信息主键
     * @return 结果
     */
    @Override
    public int deleteTBookByBookIds(Long[] bookIds)
    {
        return tBookMapper.deleteTBookByBookIds(bookIds);
    }

    /**
     * 删除图书信息信息
     * 
     * @param bookId 图书信息主键
     * @return 结果
     */
    @Override
    public int deleteTBookByBookId(Long bookId)
    {
        return tBookMapper.deleteTBookByBookId(bookId);
    }
}
