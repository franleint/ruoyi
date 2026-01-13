package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图书信息对象 t_book
 * 
 * @author ruoyi
 * @date 2026-01-12
 */
public class TBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图书ID */
    private Long bookId;

    /** 书名 */
    @Excel(name = "书名")
    private String bookName;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 存储区域 */
    @Excel(name = "存储区域")
    private String storeArea;

    /** 分类编号 */
    @Excel(name = "分类编号")
    private String categoryCode;

    /** 状态（0借出 1在馆） */
    @Excel(name = "状态", readConverterExp = "0=借出,1=在馆")
    private String status;

    /** 借阅人ID */
    private Long borrowerId;
    private String borrowerName;
    private String AreaName;
    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }public String getAreaName() {
        return AreaName;
    }public void setAreaName(String areaName) {
        this.AreaName = areaName;
    }
    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }

    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }

    public void setStoreArea(String storeArea) 
    {
        this.storeArea = storeArea;
    }

    public String getStoreArea() 
    {
        return storeArea;
    }

    public void setCategoryCode(String categoryCode) 
    {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() 
    {
        return categoryCode;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setBorrowerId(Long borrowerId) 
    {
        this.borrowerId = borrowerId;
    }

    public Long getBorrowerId() 
    {
        return borrowerId;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("bookName", getBookName())
            .append("author", getAuthor())
            .append("storeArea", getStoreArea())
            .append("categoryCode", getCategoryCode())
            .append("status", getStatus())
            .append("borrowerId", getBorrowerId())
            .append("borrowerName", getBorrowerName())
            .append("areaName", getAreaName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
