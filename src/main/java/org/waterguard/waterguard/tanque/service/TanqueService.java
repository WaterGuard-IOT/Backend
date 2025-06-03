package org.waterguard.waterguard.tanque.service;

import org.waterguard.waterguard.auth.model.Usuario;
import org.waterguard.waterguard.auth.repository.UsuarioRepository;
import org.waterguard.waterguard.tanque.dto.*;
import org.waterguard.waterguard.tanque.model.*;
import org.waterguard.waterguard.tanque.repository.TanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TanqueService {

    @Autowired
    private TanqueRepository tanqueRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tanque crearTanque(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Tanque nuevo = Tanque.builder()
                .usuario(usuario)
                .build();
        return tanqueRepository.save(nuevo);
    }

    public List<Tanque> listarTanquesPorUsuario(Long usuarioId) {
        return tanqueRepository.findByUsuarioId(usuarioId);
    }

    public Tanque obtenerPorId(Long tanqueId) {
        return tanqueRepository.findById(tanqueId).orElseThrow();
    }

    public Tanque registrarCalidad(Long tanqueId, CalidadAguaRequest request) {
        Tanque tanque = obtenerPorId(tanqueId);
        CalidadAgua calidad = CalidadAgua.builder()
                .ph(request.getPh())
                .turbidez(request.getTurbidez())
                .conductividad(request.getConductividad())
                .temperatura(request.getTemperatura())
                .fechaRegistro(LocalDateTime.now())
                .build();
        tanque.setCalidad(calidad);
        return tanqueRepository.save(tanque);
    }

    public Tanque registrarNivel(Long tanqueId, NivelAguaRequest request) {
        Tanque tanque = obtenerPorId(tanqueId);
        NivelAgua nivel = NivelAgua.builder()
                .porcentaje(request.getPorcentaje())
                .fechaMedicion(LocalDateTime.now())
                .build();
        tanque.setNivel(nivel);
        return tanqueRepository.save(tanque);
    }
}
