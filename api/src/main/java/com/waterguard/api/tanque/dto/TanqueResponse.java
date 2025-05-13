package com.waterguard.api.tanque.dto;

import com.waterguard.api.tanque.model.CalidadAgua;
import com.waterguard.api.tanque.model.NivelAgua;
import lombok.Data;

@Data
public class TanqueResponse {
    private Long tanqueId;
    private CalidadAgua calidad;
    private NivelAgua nivel;
}