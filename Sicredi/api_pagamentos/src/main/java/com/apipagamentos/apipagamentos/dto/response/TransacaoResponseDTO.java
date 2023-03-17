package com.apipagamentos.apipagamentos.dto.response;

import com.apipagamentos.apipagamentos.dto.FormaPagamentoDTO;
import lombok.Data;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Classe de resposta relacionada a transação.
 */
@Data
public class TransacaoResponseDTO {

    private int cartao;
    private Long id;
    private DescricaoResponseDTO descricao;
    private FormaPagamentoDTO formaPagamento;

}
