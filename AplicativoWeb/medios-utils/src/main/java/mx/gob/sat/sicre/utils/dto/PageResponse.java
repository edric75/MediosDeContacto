package mx.gob.sat.sicre.utils.dto;

import java.io.Serializable;

public class PageResponse implements Serializable {

    private static final long serialVersionUID = 2737576363737449014L;
    private int totalElements;
    private int totalPages;
    private int number;

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
