package pos.tech.gatrohub.infrastructure.persistence;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import pos.tech.gatrohub.domain.entity.EnderecoDTO;
import java.util.Date;

@Table(name = "endereco")
@Entity(name = "endereco")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String bairro;
    private String rua;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private Date dataUltimaALteracao;

    public Endereco(@NotNull @Valid EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.rua = endereco.rua();
        this.dataUltimaALteracao = new Date();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public Date getDataUltimaALteracao() {
        return dataUltimaALteracao;
    }
}
