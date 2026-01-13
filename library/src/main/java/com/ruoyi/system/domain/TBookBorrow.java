package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 借阅记录对象 t_book_borrow
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public class TBookBorrow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 借阅ID */
    private Long borrowId;

    /** 图书ID */
    @Excel(name = "图书ID")
    private Long bookId;

    /** 借阅人ID */
    @Excel(name = "借阅人ID")
    private Long borrowerId;

    /** 借阅时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借阅时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date borrowBegin;

    /** 归还时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "归还时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date borrowEnd;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadline;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBorrowId(Long borrowId) 
    {
        this.borrowId = borrowId;
    }

    public Long getBorrowId() 
    {
        return borrowId;
    }

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }

    public void setBorrowerId(Long borrowerId) 
    {
        this.borrowerId = borrowerId;
    }

    public Long getBorrowerId() 
    {
        return borrowerId;
    }

    public void setBorrowBegin(Date borrowBegin) 
    {
        this.borrowBegin = borrowBegin;
    }

    public Date getBorrowBegin() 
    {
        return borrowBegin;
    }

    public void setBorrowEnd(Date borrowEnd) 
    {
        this.borrowEnd = borrowEnd;
    }

    public Date getBorrowEnd() 
    {
        return borrowEnd;
    }

    public void setDeadline(Date deadline) 
    {
        this.deadline = deadline;
    }

    public Date getDeadline() 
    {
        return deadline;
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
            .append("borrowId", getBorrowId())
            .append("bookId", getBookId())
            .append("borrowerId", getBorrowerId())
            .append("borrowBegin", getBorrowBegin())
            .append("borrowEnd", getBorrowEnd())
            .append("deadline", getDeadline())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
