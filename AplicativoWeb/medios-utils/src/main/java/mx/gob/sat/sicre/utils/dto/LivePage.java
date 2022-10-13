package mx.gob.sat.sicre.utils.dto;

import java.io.Serializable;

public class LivePage implements Serializable {

    private static final long serialVersionUID = 284917863954502258L;
    private int currentPage;
    private int pageSize;
    private String filter;
    private SortPage sort;

    public LivePage() {
    }

    public LivePage(int currentPage, int size, String filter) {
        this.currentPage = currentPage;
        this.pageSize = size;
        this.filter = filter;
    }

    public LivePage(int currentPage, int size) {
        this.currentPage = currentPage;
        this.pageSize = size;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getFilter() {

        if (filter == null || filter.equals("")) {
            filter = "-";
        }

        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public SortPage getSort() {
        return sort;
    }

    public void setSort(SortPage sort) {
        this.sort = sort;
    }

}
