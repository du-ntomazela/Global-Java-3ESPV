package br.com.skillup.api.repository;

import br.com.skillup.api.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    List<Trilha> findByFocusODSContainingIgnoreCase(String focoOds);
    List<Trilha> findByTituloContainingIgnoreCase(String titulo);
}
