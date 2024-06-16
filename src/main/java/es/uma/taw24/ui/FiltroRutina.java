package es.uma.taw24.ui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author
 * Cristian Ruiz Martín: 100%
 */

public class FiltroRutina {

    protected String lowerFecha;
    protected String upperFecha;

    protected int idCliente;

    public FiltroRutina() {
        this.lowerFecha = "";
        this.upperFecha = "";
        this.idCliente = 0;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public boolean estaVacio () {
        return lowerFecha.isEmpty() && this.upperFecha.isEmpty() && this.idCliente == 0;
    }

    public Instant getLowerFechaInstant() {
        if (lowerFecha.isEmpty()) {
            return Instant.ofEpochMilli(0);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(lowerFecha, formatter);
            LocalDateTime localDateTime = localDate.atStartOfDay();
            return localDateTime.toInstant(ZoneOffset.UTC);
        }
    }

    public Instant getUpperFechaInstant() {
        if (upperFecha.isEmpty()) {
            return Instant.now();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(upperFecha, formatter);
            LocalDateTime localDateTime = localDate.atStartOfDay();
            return localDateTime.toInstant(ZoneOffset.UTC);
        }
    }

}
