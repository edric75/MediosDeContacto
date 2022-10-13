package mx.gob.sat.sicre.utils.dto;

import java.io.Serializable;

public class SortPage implements Serializable {

    private static final long serialVersionUID = 6269287423658738736L;
    private String direction;
    private String field;
    
    public SortPage() {
    }    

    public SortPage(String direction, String field) {
        this.direction = direction;
        this.field = field;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
