package org.waterguard.waterguard.tanque.repository;

import org.waterguard.waterguard.tanque.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TanqueRepository extends JpaRepository<Tanque, Long> {
    List<Tanque> findByUsuarioId(Long usuarioId);
}