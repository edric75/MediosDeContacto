package mx.gob.sat.sicre.utils.models;

public class FatherLive {

    private int currentPage;
    private String filter;
    private int pageSize;
    private FatherSort sort;

    public FatherLive() {
    }

    public FatherLive(int currentPage, String filter, int pageSize, FatherSort sort) {
        super();
        this.currentPage = currentPage;
        this.filter = filter;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getFilter() {
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

    public FatherSort getSort() {
        return sort;
    }

    public void setSort(FatherSort sort) {
        this.sort = sort;
    }

    public FatherLive(int currentPage, String filter, int pageSize) {
        super();
        this.currentPage = currentPage;
        this.filter = filter;
        this.pageSize = pageSize;
    }

}
