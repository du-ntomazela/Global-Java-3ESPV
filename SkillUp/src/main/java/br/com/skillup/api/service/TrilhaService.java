package br.com.skillup.api.service;

import br.com.skillup.api.handler.ResourceNotFoundException;
import br.com.skillup.api.model.Trilha;
import br.com.skillup.api.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    public Trilha criar(Trilha trilha) {
        return trilhaRepository.save(trilha);
    }

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada com id: " + id));
    }

    public Trilha atualizar(Long id, Trilha dadosAtualizados) {
        Trilha existente = buscarPorId(id);

        existente.setTitulo(dadosAtualizados.getTitulo());
        existente.setDescricao(dadosAtualizados.getDescricao());
        existente.setFocusODS(dadosAtualizados.getFocusODS());
        existente.setCargaHorariaEstimada(dadosAtualizados.getCargaHorariaEstimada());
        existente.setCompetencias(dadosAtualizados.getCompetencias());

        return trilhaRepository.save(existente);
    }

    public void deletar(Long id) {
        Trilha existente = buscarPorId(id);
        trilhaRepository.delete(existente);
    }
}
