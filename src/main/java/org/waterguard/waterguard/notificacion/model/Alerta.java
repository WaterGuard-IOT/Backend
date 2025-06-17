package org.waterguard.waterguard.notificacion.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tankId; // ID del tanque (puedes mapear a entidad si prefieres)
    private String type;
    private String severity;
    private String message;
    private ZonedDateTime timestamp;
    private boolean resolved;
    private boolean pumpActivated;
}