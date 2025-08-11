package pos.tech.gatrohub.application.dto;

import pos.tech.gatrohub.infrastructure.persistence.User;

public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
