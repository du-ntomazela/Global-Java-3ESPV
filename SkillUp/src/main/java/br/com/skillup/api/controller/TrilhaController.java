package br.com.skillup.api.controller;

import br.com.skillup.api.model.Trilha;
import br.com.skillup.api.service.TrilhaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
@Validated
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @PostMapping
    public ResponseEntity<Trilha> criarTrilha(@Valid @RequestBody Trilha trilha) {
        Trilha criada = trilhaService.criar(trilha);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(criada.getId())
                .toUri();

        return ResponseEntity.created(location).body(criada);
    }

    @GetMapping
    public ResponseEntity<List<Trilha>> listarTodas() {
        return ResponseEntity.ok(trilhaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscarPorId(
            @PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(trilhaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(
            @PathVariable @NotNull @Positive Long id,
            @Valid @RequestBody Trilha trilha) {

        Trilha atualizada = trilhaService.atualizar(id, trilha);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable @NotNull @Positive Long id) {

        trilhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
