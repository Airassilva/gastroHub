package pos.tech.gatrohub.domain.entity;

import pos.tech.gatrohub.infrastructure.persistence.Endereco;

import java.util.Date;

public record EnderecoDTO(

        String logradouro,

        String bairro,

        String cep,

        String cidade,

        String uf,

        String rua,

        String complemento,

        String numero,

        Date dataUltimaAlteracao) {

        public EnderecoDTO(Endereco endereco) {
            this(
                    endereco.getBairro(),
                    endereco.getCep(),
                    endereco.getCidade(),
                    endereco.getUf(),
                    endereco.getRua(),
                    endereco.getComplemento(),
                    endereco.getNumero(),
                    endereco.getLogradouro(),
                    endereco.getDataUltimaALteracao()
            );
        }
}
