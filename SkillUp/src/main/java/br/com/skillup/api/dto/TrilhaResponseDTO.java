package br.com.skillup.api.dto;

import lombok.Data;

@Data
public class TrilhaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String focoOds;
    private Integer cargaHorariaEstimada;
    private String competencias;
}
