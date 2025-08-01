package pos.tech.gatrohub.entity;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import pos.tech.gatrohub.dto.EnderecoDTO;

import java.util.Date;

@Table(name = "endereco")
@Entity(name = "endereco")
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String bairro;
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
        this.dataUltimaALteracao = new Date();
    }

}
