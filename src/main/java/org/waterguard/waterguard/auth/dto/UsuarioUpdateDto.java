package org.waterguard.waterguard.auth.dto;

import lombok.Data;

@Data
public class UsuarioUpdateDto {
    private String email;
    private String password;
}