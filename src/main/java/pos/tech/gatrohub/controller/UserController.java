package pos.tech.gatrohub.controller;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pos.tech.gatrohub.dto.UserPasswordChangeDTO;
import pos.tech.gatrohub.dto.UserRequestDTO;
import pos.tech.gatrohub.dto.UserUpdateRequestDTO;
import pos.tech.gatrohub.service.UserService;


@RestController
@RequestMapping("usuario")
public class UserController {

    UserService userService;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid UserRequestDTO requestDTO){
        userService.cadastrarUser(requestDTO);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid UserUpdateRequestDTO updateRequestDTO){
        userService.atualizarUsuario(updateRequestDTO);
    }

    @PostMapping("/login")
    public void login(@RequestBody UserPasswordChangeDTO loginRequestDTO){
        userService.login(loginRequestDTO);
    }

    @PutMapping("/trocarSenha")
    @Transactional
    public void trocarSenha(UserPasswordChangeDTO loginRequestDTO){
        userService.trocarSenha(loginRequestDTO);
    }

    @DeleteMapping
    public void deletarUsuario(UserPasswordChangeDTO loginRequestDTO){
        userService.deletarUsuario(loginRequestDTO);
    }


}
