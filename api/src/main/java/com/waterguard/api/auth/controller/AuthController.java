package com.waterguard.api.auth.controller;
import com.waterguard.api.auth.dto.AuthRequest;
import com.waterguard.api.auth.dto.AuthResponse;
import com.waterguard.api.auth.dto.RegisterRequest;
import com.waterguard.api.auth.model.Usuario;
import com.waterguard.api.auth.repository.UsuarioRepository;
import com.waterguard.api.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/users")
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }
}
