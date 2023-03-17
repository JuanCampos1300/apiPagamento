package com.apipagamentos.apipagamentos.dto.request;

import com.apipagamentos.apipagamentos.dto.FormaPagamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Classe de requisição relacionada transação.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoDTO {

    private Long id;
    @NotNull
    private int cartao;
    @NotNull
    private DescricaoDTO descricao;
    @NotNull
    private FormaPagamentoDTO formaPagamento;
}
