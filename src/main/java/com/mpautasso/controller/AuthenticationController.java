package com.mpautasso.controller;

import com.mpautasso.dto.authentication.AuthRequest;
import com.mpautasso.dto.authentication.UsuarioRegisterResponse;
import com.mpautasso.dto.authentication.UsuarioRequest;
import com.mpautasso.service.Implementation.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin("*")
public class AuthenticationController {
    private final UsuarioServiceImpl usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioRegisterResponse usuario = usuarioService.crearUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loguearUsuario(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(usuarioService.loguearUsuario(authRequest));
    }
}
