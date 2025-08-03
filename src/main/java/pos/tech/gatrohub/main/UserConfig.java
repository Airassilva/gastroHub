package pos.tech.gatrohub.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pos.tech.gatrohub.application.gateways.EnderecoGateway;
import pos.tech.gatrohub.application.gateways.UserGateway;
import pos.tech.gatrohub.infrastructure.gateways.EnderecoMapper;
import pos.tech.gatrohub.infrastructure.gateways.EnderecoRepositoryGateway;
import pos.tech.gatrohub.infrastructure.gateways.UserMapper;
import pos.tech.gatrohub.infrastructure.gateways.UserRepositoryGateway;
import pos.tech.gatrohub.infrastructure.persistence.EnderecoRepository;
import pos.tech.gatrohub.infrastructure.persistence.UserRepository;
import pos.tech.gatrohub.application.service.UserService;

@Configuration
public class UserConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public EnderecoMapper enderecoMapper() {
        return new EnderecoMapper();
    }

    @Bean
    public UserGateway userGateway(UserRepository userRepository) {
        return new UserRepositoryGateway(userRepository);
    }

    @Bean
    public EnderecoGateway enderecoGateway(EnderecoRepository enderecoRepository) {
        return new EnderecoRepositoryGateway(enderecoRepository);
    }

    @Bean
    public UserService userService(UserGateway userGateway, EnderecoGateway enderecoGateway,
                                   UserMapper userMapper, EnderecoMapper enderecoMapper) {
        return new UserService(userGateway, enderecoGateway, userMapper, enderecoMapper);
    }
}
