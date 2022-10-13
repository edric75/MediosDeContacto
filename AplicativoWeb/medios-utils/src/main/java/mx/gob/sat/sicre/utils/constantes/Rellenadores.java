package mx.gob.sat.sicre.utils.constantes;

public enum Rellenadores {

    GUION("-"), CERO("0");

    private String value;

    private Rellenadores(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
