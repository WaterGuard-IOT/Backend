package com.waterguard.api.tanque.repository;

import com.waterguard.api.tanque.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TanqueRepository extends JpaRepository<Tanque, Long> {
    List<Tanque> findByUsuarioId(Long usuarioId);
}