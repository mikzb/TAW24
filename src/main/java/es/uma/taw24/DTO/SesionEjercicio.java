/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

@Data
public class SesionEjercicio{
    private Sesion sesion;
    private Ejercicio ejercicio;
    private Integer series;
    private Integer repeticiones;
    private Short peso;
    private boolean completado;
    private Integer orden;
    private Integer velocidad;
    private Integer distancia;
    private Integer duracion;

}
