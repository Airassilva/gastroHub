package pos.tech.gatrohub.infrastructure.persistence;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import pos.tech.gatrohub.domain.entity.UserRequestDTO;

import java.util.Date;

@Table(name = "usuario")
@Entity(name = "Usuario")
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
