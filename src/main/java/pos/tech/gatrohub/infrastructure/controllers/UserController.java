package pos.tech.gatrohub.infrastructure.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.tech.gatrohub.domain.entity.*;
import pos.tech.gatrohub.application.service.UserService;


@RestController
@RequestMapping("usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UserRequestDTO requestDTO) {
            userService.cadastrarUsuario(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> listarUsuario(Pageable pageable) {
            Page<UserResponseDTO> pageDto = userService.buscarUsuariosAtivos(pageable);
            return ResponseEntity.ok(pageDto);
    }

    @PutMapping
    public ResponseEntity<String> atualizarEnderecoUsuario(@RequestBody UserUpdateEndereco endereco) {
            userService.atualizarEnderecoUsuario(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário atualizado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
            UserResponseDTO dto = userService.login(loginDTO);
            return ResponseEntity.ok(dto);
    }

    @PostMapping("/senha")
    public ResponseEntity<?> trocarSenha(@RequestBody UserPasswordChangeDTO dto) {
            userService.trocarSenha(dto);
            return ResponseEntity.ok("Senha atualizada com sucesso!");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody UserUpdateRequestDTO dto) {
        userService.atualizarUsuario(dto);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
        return ResponseEntity.ok("Usuário desativado!");
    }

}
