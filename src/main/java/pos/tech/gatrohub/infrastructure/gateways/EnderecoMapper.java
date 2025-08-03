package pos.tech.gatrohub.infrastructure.gateways;

import pos.tech.gatrohub.domain.entity.EnderecoDTO;
import pos.tech.gatrohub.infrastructure.persistence.Endereco;

public class EnderecoMapper {
    public static Endereco toEntity(EnderecoDTO enderecoDTO) {
        return new Endereco(enderecoDTO);
    }

    public EnderecoDTO toDTO(Endereco endereco) {
        return new EnderecoDTO(endereco);
    }
}
