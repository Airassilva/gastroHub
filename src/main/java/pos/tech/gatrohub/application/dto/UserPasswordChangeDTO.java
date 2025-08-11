package pos.tech.gatrohub.application.dto;

public record UserPasswordChangeDTO(
        Long id,
        String senhaAntiga,
        String senhaNova,
        String senhaConfirmacao) {
}
