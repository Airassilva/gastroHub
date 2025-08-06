package pos.tech.gatrohub.infrastructure.persistence;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import pos.tech.gatrohub.domain.entity.UserRequestDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String email;

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    private Date dataUltimaAlteracao;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @ManyToMany
    @JoinTable(
            name = "usuario_enderecos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> endereco = new ArrayList<>();

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
        this.endereco = List.of(new Endereco(request.endereco()));
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Endereco>  getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco>  endereco) {
        this.endereco = endereco;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }
}
