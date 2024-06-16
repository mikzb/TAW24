package es.uma.taw24.DTO;

import es.uma.taw24.DTO.RutinaSesion;
import es.uma.taw24.DTO.Sesion;
import es.uma.taw24.DTO.SesionEjercicio;
import es.uma.taw24.DTO.Ejercicio;

public class RutinaForm {
    private RutinaSesion rutinaSesion;
    private Sesion sesion;
    private SesionEjercicio sesionEjercicio;
    private Ejercicio ejercicio;

    // Getters y Setters
    public RutinaSesion getRutinaSesion() {
        return rutinaSesion;
    }

    public void setRutinaSesion(RutinaSesion rutinaSesion) {
        this.rutinaSesion = rutinaSesion;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public SesionEjercicio getSesionEjercicio() {
        return sesionEjercicio;
    }

    public void setSesionEjercicio(SesionEjercicio sesionEjercicio) {
        this.sesionEjercicio = sesionEjercicio;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
