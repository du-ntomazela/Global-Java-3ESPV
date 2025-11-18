package br.com.skillup.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InscricaoRequestDTO {

    @NotNull(message = "O id do usuário é obrigatório.")
    private Long idUsuario;

    @NotNull(message = "O id da trilha é obrigatório.")
    private Long idTrilha;
}
