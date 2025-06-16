package org.waterguard.waterguard.tanque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TanqueRequestDto {
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