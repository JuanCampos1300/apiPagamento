package com.apipagamentos.apipagamentos.repository;

import com.apipagamentos.apipagamentos.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Repositorio relacionada a transação
 */
@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Optional<Transacao> findById(Long id);

    List<Transacao> findAll();
}
