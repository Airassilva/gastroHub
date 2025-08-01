package pos.tech.gatrohub.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pos.tech.gatrohub.dto.UserRequestDTO;
import pos.tech.gatrohub.entity.User;
import pos.tech.gatrohub.repository.UserRepository;


@RestController
@RequestMapping("usuario")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid UserRequestDTO requestDTO){
        userRepository.save(new User(requestDTO));
    }

}
