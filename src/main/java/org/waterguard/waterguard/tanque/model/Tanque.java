package org.waterguard.waterguard.tanque.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.waterguard.waterguard.auth.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    private String name;

    private double capacity;

    private double currentLevel;

    private double criticalLevel;

    private double optimalLevel;

    private LocalDateTime lastUpdated;

    private String status; // e.g., "normal", "warning"

    private boolean pumpActive;

    @Embedded
    private Location location;

}
