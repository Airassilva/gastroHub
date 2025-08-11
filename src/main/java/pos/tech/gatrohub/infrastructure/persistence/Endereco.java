package pos.tech.gatrohub.infrastructure.persistence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import pos.tech.gatrohub.application.dto.EnderecoDTO;
import java.util.Date;

@Table(name = "endereco")
@Entity(name = "endereco")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo logradouro é obrigatório.")
    private String logradouro;

    @NotBlank(message = "O campo bairro é obrigatório.")
    private String bairro;

    @NotBlank(message = "O campo rua é obrigatório.")
    private String rua;

    @NotBlank(message = "O campo cep é obrigatório.")
    private String cep;

    @NotBlank(message = "O campo cidade é obrigatório.")
    private String cidade;

    @NotBlank(message = "O campo uf é obrigatório.")
    private String uf;

    private Date dataUltimaALteracao;
    private String numero;
    private String complemento;

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
