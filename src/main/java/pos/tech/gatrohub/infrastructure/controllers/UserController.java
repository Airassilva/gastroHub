package pos.tech.gatrohub.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pos.tech.gatrohub.application.dto.*;
import pos.tech.gatrohub.application.service.UserService;


@RestController
@RequestMapping("usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Cadastro",
            description = "Registra um novo usuário e retorna mensagem de sucesso"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuário cadastrado com sucesso!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                "Usuário cadastrado com sucesso!"
                """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos: CPF ou CNPJ ausente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 400,
                  "errors": [
                    "Campo 'cpf' é obrigatório",
                    "Informe CPF ou CNPJ para cadastro"
                  ]
                }
                """
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UserRequestDTO requestDTO) {
            userService.cadastrarUsuario(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }

    @Operation(
            summary = "Listar usuários ativos",
            description = "Retorna todos os usuários ativos com paginação"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de usuários ativos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Parâmetros de paginação inválidos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 500,
                  "errors": [
                    "Erro interno do servidor. Tente novamente mais tarde"
                  ]
                }
                """
                            )
                    )
            )
    })
    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> listarUsuario(Pageable pageable) {
            Page<UserResponseDTO> pageDto = userService.buscarUsuariosAtivos(pageable);
            return ResponseEntity.ok(pageDto);
    }

    @Operation(
            summary = "Atualizar endereço",
            description = "Atualiza o endereço de um usuário existente"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuário atualizado com sucesso!",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados de endereço inválidos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 400,
                  "errors": [
                    "Campo 'cidade' é obrigatório"
                  ]
                }
                """
                            )
                    )
            )
    })
    @PutMapping
    public ResponseEntity<String> atualizarEnderecoUsuario(@RequestBody UserUpdateEndereco endereco) {
            userService.atualizarEnderecoUsuario(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário atualizado com sucesso!");
    }

    @Operation(
            summary = "Login",
            description = "Autentica o usuário com login e senha"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Login realizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Credenciais inválidas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 401,
                  "errors": [
                    "Login ou senha incorretos"
                  ]
                }
                """
                            )
                    )
            )
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
            UserResponseDTO dto = userService.login(loginDTO);
            return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Trocar senha",
            description = "Permite ao usuário alterar sua senha"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Senha atualizada com sucesso!",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Senha antiga inválida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 400,
                  "errors": [
                    " A nova senha não pode ser igual à senha atual."
                  ]
                }
                """
                            )
                    )
            )
    })
    @PostMapping("/senha")
    public ResponseEntity<?> trocarSenha(@RequestBody UserPasswordChangeDTO dto) {
            userService.trocarSenha(dto);
            return ResponseEntity.ok("Senha atualizada com sucesso!");
    }

    @Operation(
            summary = "Atualizar dados do usuário",
            description = "Atualiza o e-mail e o endereço do usuário"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário atualizado com sucesso!",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "CEP inválido ou ausente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 400,
                  "errors": [
                    "Campo 'cep' é obrigatório"
                  ]
                }
                """
                            )
                    )
            )
    })
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody UserUpdateRequestDTO dto) {
        userService.atualizarUsuario(dto);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }

    @Operation(
            summary = "Desativar usuário",
            description = "Desativa o usuário com base no ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário desativado!",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "ID ausente ou inválido",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    example = """
                {
                  "timestamp": "2025-08-11T21:00:00Z",
                  "status": 500,
                  "errors": [
                    "Erro interno do servidor. Tente novamente mais tarde"
                  ]
                }
                """
                            )
                    )
            )
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
        return ResponseEntity.ok("Usuário desativado!");
    }

}
