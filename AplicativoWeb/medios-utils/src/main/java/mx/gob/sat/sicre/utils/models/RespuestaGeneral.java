package mx.gob.sat.sicre.utils.models;

public class RespuestaGeneral {

    private boolean exito;
    private boolean error;
    private String msj;

    public boolean isError() {
        return error;
    }

    public RespuestaGeneral() {
        this.error = false;
        this.exito = true;
    }

    public void respuestaErronea(String msj) {
        this.error = false;
        this.exito = true;
        this.msj = msj;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

}
