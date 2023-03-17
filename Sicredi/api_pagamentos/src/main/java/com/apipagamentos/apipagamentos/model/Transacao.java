package com.apipagamentos.apipagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Entidade relacionada a transação
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transacao {

    @Id
    private Long id;

    private int cartao;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn
    private Descricao descricao;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn
    private FormaPagamento formaPagamento;

}
