package org.waterguard.waterguard.auth.controller;
import org.waterguard.waterguard.auth.dto.AuthRequest;
import org.waterguard.waterguard.auth.dto.AuthResponse;
import org.waterguard.waterguard.auth.dto.RegisterRequest;
import org.waterguard.waterguard.auth.model.Usuario;
import org.waterguard.waterguard.auth.repository.UsuarioRepository;
import org.waterguard.waterguard.auth.service.AuthService;
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
