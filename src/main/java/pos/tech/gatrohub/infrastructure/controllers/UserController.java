package pos.tech.gatrohub.infrastructure.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.tech.gatrohub.domain.entity.UserPasswordChangeDTO;
import pos.tech.gatrohub.domain.entity.UserRequestDTO;
import pos.tech.gatrohub.domain.entity.UserUpdateRequestDTO;
import pos.tech.gatrohub.application.service.UserService;


@RestController
@RequestMapping("usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid UserRequestDTO requestDTO) {
        try {
            userService.cadastrarUsuario(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserPasswordChangeDTO loginDTO) {
        try {
            userService.login(loginDTO);
            return ResponseEntity.ok("Login concluído com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/senha")
    public ResponseEntity<?> trocarSenha(@RequestBody UserPasswordChangeDTO dto) {
        userService.trocarSenha(dto);
        return ResponseEntity.ok("Senha atualizada com sucesso!");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody @Valid UserUpdateRequestDTO dto) {
        userService.atualizarUsuario(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarUsuario(@RequestBody UserPasswordChangeDTO dto) {
        userService.deletarUsuario(dto);
        return ResponseEntity.ok().build();
    }

}
