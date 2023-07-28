package br.com.estacio.controle.repository;

import br.com.estacio.controle.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByDescricao(String descricaoDespesa);
}
