package com.waterguard.api.auth.service;
import com.waterguard.api.auth.dto.AuthRequest;
import com.waterguard.api.auth.dto.AuthResponse;
import com.waterguard.api.auth.dto.RegisterRequest;
import com.waterguard.api.auth.jwt.JwtUtil;
import com.waterguard.api.auth.model.Usuario;
import com.waterguard.api.auth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse login(AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = jwtUtil.generateToken(request.getUsername());
        return new AuthResponse(token);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {
        Usuario nuevo = new Usuario();
        nuevo.setUsername(request.getUsername());
        nuevo.setEmail(request.getEmail());
        nuevo.setPassword(passwordEncoder.encode(request.getPassword()));

        usuarioRepository.save(nuevo);
        return "Usuario registrado correctamente";
    }
}
