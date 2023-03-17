package com.apipagamentos.apipagamentos.dto.response;

import com.apipagamentos.apipagamentos.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Classe de resposta relacionada a descriçao.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescricaoResponseDTO {

    private double valor;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;
    private String estabelecimento;
    private long nsu;
    private long codigoAutorizacao;
    private Status status;

}
