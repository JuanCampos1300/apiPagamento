package com.apipagamentos.apipagamentos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Classe de resposta relacionada a pagamento.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoResponseDTO {

    private TransacaoResponseDTO transacao;

}
