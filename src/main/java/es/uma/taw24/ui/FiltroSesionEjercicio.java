package es.uma.taw24.ui;

/**
 * @author
 * Cristian Ruiz Martín: 100%
 */


public class FiltroSesionEjercicio {
    private Integer idSesion;
    private Integer series;
    private Integer repeticiones;
    private Integer peso;
    private Boolean completado;

    public FiltroSesionEjercicio() {
        this.idSesion = 0;
        this.series = 0;
        this.repeticiones = 0;
        this.peso = 0;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public boolean estaVacio() {
        return series == null && repeticiones == null && peso == null;
    }
}
