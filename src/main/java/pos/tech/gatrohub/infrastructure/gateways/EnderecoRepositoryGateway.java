package pos.tech.gatrohub.infrastructure.gateways;

import pos.tech.gatrohub.application.gateways.EnderecoGateway;
import pos.tech.gatrohub.infrastructure.persistence.Endereco;
import pos.tech.gatrohub.infrastructure.persistence.EnderecoRepository;

public class EnderecoRepositoryGateway implements EnderecoGateway {
    private final EnderecoRepository enderecoRepository;

    public EnderecoRepositoryGateway(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
