package com.apipagamentos.apipagamentos.repository;

import com.apipagamentos.apipagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Repositorio relacionada a pagamento
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Optional<Pagamento> findById(Long id);

    List<Pagamento> findAll();
}
