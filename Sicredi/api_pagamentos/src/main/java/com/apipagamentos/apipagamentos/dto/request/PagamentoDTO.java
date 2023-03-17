package com.apipagamentos.apipagamentos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Classe de requisição relacionada a pagamento
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    @NotNull //não permite valores nulos
    private TransacaoDTO transacao;
}
