package br.com.skillup.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InscricaoResponseDTO {

    private Long id;
    private Long idUsuario;
    private Long idTrilha;
    private LocalDate dataInscricao;
}
