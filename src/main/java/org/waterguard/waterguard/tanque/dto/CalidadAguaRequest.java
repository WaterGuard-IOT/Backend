package org.waterguard.waterguard.tanque.dto;

import lombok.Data;

@Data
public class CalidadAguaRequest {
    private Double ph;
    private Double turbidez;
    private Double conductividad;
    private Double temperatura;
}