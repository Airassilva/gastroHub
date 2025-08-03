package pos.tech.gatrohub.infrastructure.persistence;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import pos.tech.gatrohub.domain.entity.UserRequestDTO;

import java.util.Date;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String cnpj;
    private String login;
    private String senha;
    private Date dataCadastro;
    private Date dataUltimaAlteracao;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public User(@Valid UserRequestDTO request) {
        this.nome = request.nome();
        this.email = request.email();
        this.cpf = request.cpf();
        this.cnpj = request.cnpj();
        this.login = request.login();
        this.senha = request.senha();
        this.tipoUsuario = request.tipoUsuario();
        this.dataCadastro = new Date();
        this.dataUltimaAlteracao = new Date();
        this.ativo = true;
        this.endereco = new Endereco(request.endereco());
    }
}
