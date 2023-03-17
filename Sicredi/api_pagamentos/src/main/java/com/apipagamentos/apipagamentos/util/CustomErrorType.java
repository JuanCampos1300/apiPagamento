package com.apipagamentos.apipagamentos.util;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Classe que representa mensagem de erro.
 */
public class CustomErrorType {
    private String messageErro;

    public CustomErrorType(String messageErro) {
        this.messageErro = messageErro;
    }

    public String getErrorMessage() {
        return messageErro;
    }
}

