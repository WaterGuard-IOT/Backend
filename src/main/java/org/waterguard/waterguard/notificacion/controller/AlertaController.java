package org.waterguard.waterguard.notificacion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.waterguard.waterguard.notificacion.model.Alerta;
import org.waterguard.waterguard.notificacion.service.AlertaService;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService alertaService;

    @PostMapping
    public ResponseEntity<Alerta> crear(@RequestBody Alerta alerta) {
        return ResponseEntity.ok(alertaService.crear(alerta));
    }

    @GetMapping
    public ResponseEntity<List<Alerta>> listar() {
        return ResponseEntity.ok(alertaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(alertaService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> actualizar(@PathVariable Long id, @RequestBody Alerta alerta) {
        return ResponseEntity.ok(alertaService.actualizar(id, alerta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        alertaService.eliminar(id);
        return ResponseEntity.ok("Alerta eliminada correctamente.");
    }

    @GetMapping("/tanque/{tankId}")
    public ResponseEntity<List<Alerta>> listarPorTanque(@PathVariable String tankId) {
        return ResponseEntity.ok(alertaService.buscarPorTanque(tankId));
    }
}