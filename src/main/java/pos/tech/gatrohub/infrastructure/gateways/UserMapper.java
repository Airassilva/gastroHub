package pos.tech.gatrohub.infrastructure.gateways;

import pos.tech.gatrohub.application.dto.UserRequestDTO;
import pos.tech.gatrohub.application.dto.UserResponseDTO;
import pos.tech.gatrohub.infrastructure.persistence.User;

public class UserMapper {
    public static User toEntity(UserRequestDTO requestDTO) {
        return new User(requestDTO);
    }

    public UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user);
    }
}
