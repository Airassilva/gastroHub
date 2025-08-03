package pos.tech.gatrohub.infrastructure.gateways;

import pos.tech.gatrohub.domain.entity.UserRequestDTO;
import pos.tech.gatrohub.infrastructure.persistence.User;

public class UserMapper {
    public static User toEntity(UserRequestDTO requestDTO) {
        return new User(requestDTO);
    }

    UserRequestDTO toDTO(User user) {
        return new UserRequestDTO(user);
    }
}
