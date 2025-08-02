package pos.tech.gatrohub.service;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pos.tech.gatrohub.dto.UserPasswordChangeDTO;
import pos.tech.gatrohub.dto.UserRequestDTO;
import pos.tech.gatrohub.dto.UserUpdateRequestDTO;
import pos.tech.gatrohub.entity.Endereco;
import pos.tech.gatrohub.entity.User;
import pos.tech.gatrohub.repository.EnderecoRepository;
import pos.tech.gatrohub.repository.UserRepository;

import java.util.Optional;

public class UserService {

    EnderecoRepository enderecoRepository;
    UserRepository userRepository;

    public void cadastrarUser(UserRequestDTO requestDTO) {
        Endereco enderecoSalvo =
                enderecoRepository.save(new Endereco(requestDTO.endereco()));
        User usuario = new User(requestDTO);
        usuario.setEndereco(enderecoSalvo);
        userRepository.save(usuario);
    }

    public ResponseEntity<?> login(UserPasswordChangeDTO loginRequestDTO) {
        Optional<User> optionalUser =
                userRepository.findByLoginAndSenha(loginRequestDTO.login(), loginRequestDTO.senha());
        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok("Login concluído com sucesso!");
    }

    public ResponseEntity<?> trocarSenha(UserPasswordChangeDTO passwordChangeDTO) {
        Optional<User> optionalUser =
                userRepository.findByLogin(passwordChangeDTO.login());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Login não encontrado.");
        }

        User user = optionalUser.get();
        user.setSenha(passwordChangeDTO.senha());
        userRepository.save(user);
        return ResponseEntity.ok("Senha atualizada com sucesso!");
    }

    public void atualizarUsuario(@Valid UserUpdateRequestDTO updateRequestDTO) {
        Optional<User> optionalUser =
                userRepository.findById(updateRequestDTO.id());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado no sistema");
        }

        User user = optionalUser.get();
        user.setEmail(updateRequestDTO.email());
        user.setEndereco(updateRequestDTO.endereco());

        userRepository.save(user);
    }

    public void deletarUsuario(UserPasswordChangeDTO loginRequestDTO) {
        Optional<User> optionalUser =
                userRepository.findByLoginAndSenha(loginRequestDTO.login(), loginRequestDTO.senha());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado para exclusão");
        }
        User user = optionalUser.get();
        user.setAtivo(false);
    }
}
