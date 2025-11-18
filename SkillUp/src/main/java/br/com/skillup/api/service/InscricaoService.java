package br.com.skillup.api.service;

import br.com.skillup.api.handler.ResourceNotFoundException;
import br.com.skillup.api.model.Inscricao;
import br.com.skillup.api.model.Trilha;
import br.com.skillup.api.model.Usuario;
import br.com.skillup.api.repository.InscricaoRepository;
import br.com.skillup.api.repository.TrilhaRepository;
import br.com.skillup.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TrilhaRepository trilhaRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository,
                            UsuarioRepository usuarioRepository,
                            TrilhaRepository trilhaRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.trilhaRepository = trilhaRepository;
    }

    public Inscricao inscreverUsuarioEmTrilha(Long idUsuario, Long idTrilha) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: " + idUsuario));

        Trilha trilha = trilhaRepository.findById(idTrilha)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada com id: " + idTrilha));

        Inscricao inscricao = new Inscricao();
        inscricao.setUsuario(usuario);
        inscricao.setTrilha(trilha);
        inscricao.setDataInscricao(LocalDate.now());

        return inscricaoRepository.save(inscricao);
    }

    public List<Inscricao> listarInscricoesUsuario(Long idUsuario) {
        // usando o código base que você tinha (sem otimizações de query)
        return inscricaoRepository.findAll().stream()
                .filter(i -> i.getUsuario().getId().equals(idUsuario))
                .toList();
    }

    public List<Inscricao> listarTodas() {
        return inscricaoRepository.findAll();
    }
}
