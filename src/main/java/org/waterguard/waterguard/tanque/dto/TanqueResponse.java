package org.waterguard.waterguard.tanque.dto;

import org.waterguard.waterguard.tanque.model.CalidadAgua;
import org.waterguard.waterguard.tanque.model.NivelAgua;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TanqueResponse {
    private Long tanqueId;
    private String name;
    private double capacity;
    private double currentLevel;
    private double criticalLevel;
    private double optimalLevel;
    private boolean pumpActive;
    private String status;
    private LocationDto location;
    private Long userId;
}