package br.com.skillup.api.controller;

import br.com.skillup.api.model.Inscricao;
import br.com.skillup.api.service.InscricaoService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
@Validated
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public ResponseEntity<Inscricao> inscrever(
            @RequestParam @NotNull @Positive Long idUsuario,
            @RequestParam @NotNull @Positive Long idTrilha) {

        Inscricao inscricao = inscricaoService.inscreverUsuarioEmTrilha(idUsuario, idTrilha);
        return ResponseEntity.ok(inscricao);
    }

    @GetMapping
    public ResponseEntity<List<Inscricao>> listarTodas() {
        return ResponseEntity.ok(inscricaoService.listarTodas());
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Inscricao>> listarPorUsuario(
            @PathVariable @NotNull @Positive Long idUsuario) {

        return ResponseEntity.ok(inscricaoService.listarInscricoesUsuario(idUsuario));
    }
}

