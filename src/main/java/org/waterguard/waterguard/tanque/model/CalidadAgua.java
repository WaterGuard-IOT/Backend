package org.waterguard.waterguard.tanque.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalidadAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double ph;
    private Double turbidez;
    private Double conductividad;
    private Double temperatura;

    private LocalDateTime fechaRegistro;
}

