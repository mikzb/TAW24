/*
 * Pablo Rubia Arias: 100%
 */

package es.uma.taw24.DTO;

import lombok.Data;

import java.time.Instant;

@Data
public class Dia {
    private Integer id;
    private Instant fecha;
    private Menu menu;
}
