package org.waterguard.waterguard.tanque.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.waterguard.waterguard.auth.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    private CalidadAgua calidad;

    @OneToOne(cascade = CascadeType.ALL)
    private NivelAgua nivel;
}
