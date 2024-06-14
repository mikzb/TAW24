package es.uma.taw24.ui;

/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

public class FiltroRutina {

    protected String lowerFecha;
    protected String upperFecha;
    protected int sesiones;

    public FiltroRutina() {
        this.lowerFecha = "";
        this.upperFecha = "";
        this.sesiones = 0;
    }

    public String getLowerFecha() {
        return lowerFecha;
    }

    public void setLowerFecha(String lowerFecha) {
        this.lowerFecha = lowerFecha;
    }

    public String getUpperFecha() {
        return upperFecha;
    }

    public void setUpperFecha(String upperFecha) {
        this.upperFecha = upperFecha;
    }

    public int getSesiones() {
        return sesiones;
    }

    public void setSesiones(int sesiones) {
        this.sesiones = sesiones;
    }


    public boolean estaVacio () {
        return lowerFecha.isEmpty() && this.upperFecha.isEmpty() && this.sesiones == 0;

    }

}
