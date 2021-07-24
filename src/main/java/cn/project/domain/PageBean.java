package cn.project.domain;

import java.util.List;

/**
 * 分页对象
 * @param <T>
 */
public class PageBean<T> {
    private int TotalCount;  //查询结果总条数
    private int pageCount;   //总页码数
    private List<T> list;    //每页展示数据的集合
    private int rows;        //每页展示的条数
    private int currentPage; //当前页码数

    public PageBean(int totalCount, int pageCount, List<T> list, int rows, int currentPage) {
        TotalCount = totalCount;
        this.pageCount = pageCount;
        this.list = list;
        this.rows = rows;
        this.currentPage = currentPage;
    }

    public PageBean() {
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "TotalCount=" + TotalCount +
                ", pageCount=" + pageCount +
                ", list=" + list +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                '}';
    }
}
