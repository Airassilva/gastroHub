package pos.tech.gatrohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record EnderecoDTO(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento,

        String numero,

        Date dataUltimaAlteracao) {
}
