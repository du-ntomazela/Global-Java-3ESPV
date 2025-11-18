package br.com.skillup.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRILHAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRILHA")
    private Long id;

    @NotBlank(message = "O campo título é obrigatório.")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres.")
    @Column(name = "TITULO", nullable = false, length = 150)
    private String titulo;

    @NotBlank(message = "O campo descrição é obrigatório.")
    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    @Column(name = "DESCRICAO", nullable = false, length = 500)
    private String descricao;

    @NotBlank(message = "O campo de ODS de foco é obrigatório.")
    @Size(max = 100, message = "O foco de ODS deve ter no máximo 100 caracteres.")
    @Column(name = "FOCO_ODS", nullable = false, length = 100)
    private String focusODS;

    @NotNull(message = "O campo de carga horária é obrigatório.")
    @Column(name = "CARGA_HORARIA_ESTIMADA", nullable = false)
    private Integer cargaHorariaEstimada;

    @NotBlank(message = "O campo de competências é obrigatório.")
    @Size(max = 255, message = "As competências devem ter no máximo 255 caracteres.")
    @Column(name = "COMPETENCIAS", nullable = false, length = 255)
    private String competencias;
}
