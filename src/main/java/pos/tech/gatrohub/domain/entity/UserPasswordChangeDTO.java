package pos.tech.gatrohub.domain.entity;

public record UserPasswordChangeDTO(
        Long id,
        String senhaConfirmacao,
        String senhaAntiga,
        String senhaNova) {
}
