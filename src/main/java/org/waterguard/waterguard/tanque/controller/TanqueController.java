package org.waterguard.waterguard.tanque.controller;

import org.waterguard.waterguard.tanque.dto.*;
import org.waterguard.waterguard.tanque.model.Tanque;
import org.waterguard.waterguard.tanque.service.TanqueService;
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
    @PostMapping("/tanque")
    public ResponseEntity<Tanque> createTank(@RequestBody TanqueRequestDto dto) {
        Tanque tank = tanqueService.createTanqueFromDto(dto);
        return ResponseEntity.ok(tank);
    }
    @PutMapping("tanque/{id}")
    public ResponseEntity<Tanque> updateTank(@PathVariable Long id, @RequestBody TanqueRequestDto dto) {
        Tanque updated = tanqueService.actualizarTanque(id, dto);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/tanque/{id}")
    public ResponseEntity<String> deleteTank(@PathVariable Long id) {
        tanqueService.eliminarTanque(id);
        return ResponseEntity.ok("Tank with ID " + id + " was successfully deleted.");
    }
//    @PostMapping("/tanque/{tanqueId}/calidad")
//    public ResponseEntity<Tanque> registrarCalidad(@PathVariable Long tanqueId, @RequestBody CalidadAguaRequest request) {
//        return ResponseEntity.ok(tanqueService.registrarCalidad(tanqueId, request));
//    }

//    @PostMapping("/tanque/{tanqueId}/nivel")
//    public ResponseEntity<Tanque> registrarNivel(@PathVariable Long tanqueId, @RequestBody NivelAguaRequest request) {
//        return ResponseEntity.ok(tanqueService.registrarNivel(tanqueId, request));
//    }
}
