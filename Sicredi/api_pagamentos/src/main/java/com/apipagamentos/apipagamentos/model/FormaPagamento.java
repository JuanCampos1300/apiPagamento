package com.apipagamentos.apipagamentos.model;

import com.apipagamentos.apipagamentos.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Entidade relacionada a forma de pagamento
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Tipo tipo;
    private int parcelas;

}
