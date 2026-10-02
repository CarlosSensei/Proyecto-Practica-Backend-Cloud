package com.ccsw.tutorial_auth.login;

import com.ccsw.tutorial_auth.login.model.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final JwtService jwtService;

    public LoginController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {

        if ("admin".equals(dto.getUser()) && "admin".equals(dto.getPassword())) {

            String token = jwtService.generateToken(dto.getUser());
            return ResponseEntity.ok(token);
        }

        throw new IllegalArgumentException("Logged in as a Basic User");
    }
}