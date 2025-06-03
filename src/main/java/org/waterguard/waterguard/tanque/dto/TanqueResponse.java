package org.waterguard.waterguard.tanque.dto;

import org.waterguard.waterguard.tanque.model.CalidadAgua;
import org.waterguard.waterguard.tanque.model.NivelAgua;
import lombok.Data;

@Data
public class TanqueResponse {
    private Long tanqueId;
    private CalidadAgua calidad;
    private NivelAgua nivel;
}