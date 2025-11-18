package br.com.skillup.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TrilhaRequestDTO {

    @NotBlank(message = "O título é obrigatório.")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres.")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    private String descricao;

    @NotBlank(message = "O foco ODS é obrigatório.")
    @Size(max = 100, message = "O foco ODS deve ter no máximo 100 caracteres.")
    private String focoOds;

    @NotNull(message = "A carga horária estimada é obrigatória.")
    private Integer cargaHorariaEstimada;

    @NotBlank(message = "As competências são obrigatórias.")
    @Size(max = 255, message = "As competências devem ter no máximo 255 caracteres.")
    private String competencias;
}
