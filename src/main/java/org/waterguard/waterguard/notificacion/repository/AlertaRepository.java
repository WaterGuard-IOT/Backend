package org.waterguard.waterguard.notificacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.waterguard.waterguard.notificacion.model.Alerta;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByTankId(String tankId);
}