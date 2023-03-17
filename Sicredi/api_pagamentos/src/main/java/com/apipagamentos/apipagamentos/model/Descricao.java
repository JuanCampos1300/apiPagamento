package com.apipagamentos.apipagamentos.model;

import com.apipagamentos.apipagamentos.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Entidade relacionada a descrição
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Descricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private LocalDateTime dataHora;
    private String estabelecimento;
    private long nsu;
    private long codigoAutorizacao;
    private Status status;

}


