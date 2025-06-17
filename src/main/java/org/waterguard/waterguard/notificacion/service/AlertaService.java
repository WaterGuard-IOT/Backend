package org.waterguard.waterguard.notificacion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.waterguard.waterguard.notificacion.model.Alerta;
import org.waterguard.waterguard.notificacion.repository.AlertaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository alertaRepository;

    public Alerta crear(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public List<Alerta> listar() {
        return alertaRepository.findAll();
    }

    public Alerta obtener(Long id) {
        return alertaRepository.findById(id).orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
    }

    public Alerta actualizar(Long id, Alerta alertaActualizada) {
        Alerta existente = obtener(id);
        existente.setResolved(alertaActualizada.isResolved());
        existente.setPumpActivated(alertaActualizada.isPumpActivated());
        existente.setSeverity(alertaActualizada.getSeverity());
        existente.setMessage(alertaActualizada.getMessage());
        existente.setType(alertaActualizada.getType());
        return alertaRepository.save(existente);
    }

    public void eliminar(Long id) {
        alertaRepository.deleteById(id);
    }

    public List<Alerta> buscarPorTanque(String tankId) {
        return alertaRepository.findByTankId(tankId);
    }
}