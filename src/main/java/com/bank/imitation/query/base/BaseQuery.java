package com.bank.imitation.query.base;

/**
 * Created by mogu on 2016/8/18.
 */
public class BaseQuery {

    /** 缺省页大小 */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /** 最大页大小 **/
    public static final int MAX_PAGE_SIZE     = 1000;

    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private int totalRecord;
    /**
     * 当前页
     */
    private int pageIndex;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * 默认desc=true,desc=false即asc
     */
    private boolean desc = true;

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    /**
     * 总条目数
     *
     * @param totalRecord
     */
    public void setTotalRecord(int totalRecord) {
        this.totalPage = (totalRecord + getPageSize() - 1) / getPageSize();
        this.totalRecord = totalRecord;
    }

    /**
     * 当前页
     *
     * @return
     */
    public int getPageIndex() {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return pageIndex;
    }

    public boolean hasNextPage() {
        if (pageIndex <= getTotalPage()) {
            return true;
        } else {
            return false;
        }
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    /**
     * mysql开始位置
     *
     * @return
     */
    public int getStartPos() {
        int cPage = getPageIndex();

        if (cPage <= 1) {
            return 0;
        }

        cPage--;

        int pgSize = getPageSize();

        return (pgSize * cPage);
    }

    /**
     * 结束位置
     *
     * @return
     */
    public int getEndPos() {
        /**
         * 未设置总记录数或设置了总记录数 页码*每页数量<总记录数
         */
        if (getTotalRecord() == 0 || getPageIndex() * getPageSize() < getTotalRecord()) {
            return getPageIndex() * getPageSize();
        } else {
            return getTotalRecord();
        }
    }

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 排序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 排序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 默认desc=true,desc=false即asc
     */
    public boolean getDesc() {
        return desc;
    }

    /**
     * 默认desc=true,desc=false即asc
     */
    public void setDesc(boolean desc) {
        this.desc = desc;
    }
}
