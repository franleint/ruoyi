package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TBook;

/**
 * 图书信息Service接口
 * 
 * @author ruoyi
 * @date 2026-01-12
 */
public interface ITBookService 
{
    /**
     * 查询图书信息
     * 
     * @param bookId 图书信息主键
     * @return 图书信息
     */
    public TBook selectTBookByBookId(Long bookId);

    /**
     * 查询图书信息列表
     * 
     * @param tBook 图书信息
     * @return 图书信息集合
     */
    public List<TBook> selectTBookList(TBook tBook);

    /**
     * 新增图书信息
     * 
     * @param tBook 图书信息
     * @return 结果
     */
    public int insertTBook(TBook tBook);

    /**
     * 修改图书信息
     * 
     * @param tBook 图书信息
     * @return 结果
     */
    public int updateTBook(TBook tBook);

    /**
     * 批量删除图书信息
     * 
     * @param bookIds 需要删除的图书信息主键集合
     * @return 结果
     */
    public int deleteTBookByBookIds(Long[] bookIds);

    /**
     * 删除图书信息信息
     * 
     * @param bookId 图书信息主键
     * @return 结果
     */
    public int deleteTBookByBookId(Long bookId);
}
