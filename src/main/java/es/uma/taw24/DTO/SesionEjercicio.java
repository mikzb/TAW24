package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class SesionEjercicio{
    private Sesion sesion;
    private Ejercicio ejercicio;
    private int repeticiones;
    private int series;
    private short peso;
    private boolean completado;
    private int orden;
    private int velocidad;
    private int distancia;
    private int duracion;

}