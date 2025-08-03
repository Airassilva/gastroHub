package pos.tech.gatrohub.application.gateways;

import pos.tech.gatrohub.infrastructure.persistence.Endereco;

public interface EnderecoGateway {
    Endereco salvar(Endereco endereco);
}
