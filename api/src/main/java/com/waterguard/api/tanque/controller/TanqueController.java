package com.waterguard.api.tanque.controller;

import com.waterguard.api.tanque.dto.*;
import com.waterguard.api.tanque.model.Tanque;
import com.waterguard.api.tanque.service.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TanqueController {

    @Autowired
    private TanqueService tanqueService;

    @PostMapping("/usuario/{usuarioId}/tanques")
    public ResponseEntity<Tanque> crearTanque(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(tanqueService.crearTanque(usuarioId));
    }

    @GetMapping("/usuario/{usuarioId}/tanques")
    public ResponseEntity<List<Tanque>> listarTanques(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(tanqueService.listarTanquesPorUsuario(usuarioId));
    }

    @GetMapping("/tanque/{tanqueId}")
    public ResponseEntity<Tanque> obtenerTanque(@PathVariable Long tanqueId) {
        return ResponseEntity.ok(tanqueService.obtenerPorId(tanqueId));
    }

    @PostMapping("/tanque/{tanqueId}/calidad")
    public ResponseEntity<Tanque> registrarCalidad(@PathVariable Long tanqueId, @RequestBody CalidadAguaRequest request) {
        return ResponseEntity.ok(tanqueService.registrarCalidad(tanqueId, request));
    }

    @PostMapping("/tanque/{tanqueId}/nivel")
    public ResponseEntity<Tanque> registrarNivel(@PathVariable Long tanqueId, @RequestBody NivelAguaRequest request) {
        return ResponseEntity.ok(tanqueService.registrarNivel(tanqueId, request));
    }
}
