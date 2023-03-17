<h1 align="center"> Projeto desenvolvido com o objetivo de criar uma API REST que simula requisições de pagamentos e estornos.</h1>

Tecnologias utilizadas,
- Java
- Spring Boot
- Spring Data
- JPA
- H2
- JUnit, Mockito;

Funcionalidades
As principais funcionalidades do projeto são:
- Consultar um pagamento específico;
- Listar todos os pagamentos e seus status;
- Realizar o estorno de um pagamento;
- Cadastrar um novo pagamento;

Serviços e sistemas usados
-GitHub
-Intellij


Como usar
Ao iniciar o sistema, a API oferece os seguintes métodos request:

RequestMethod GET para a URL: http://localhost:8080/api/pagamento - Retorna uma lista de todos os pagamentos realizados e seus respectivos status.

RequestMethod POST para a URL: http://localhost:8080/api/pagamento - Cadastra um novo pagamento, seguindo o exemplo:

Exemplo: 
```
{
   "transacao":{
      "cartao":"12559856",
      "id":1254,
      "descricao":{
         "valor":"980.00",
         "dataHora":"22/10/2022 13:58:00",
         "estabelecimento":"Scredi"
      },
      "formaPagamento":{
         "tipo":"PARCELADO_LOJA",
         "parcelas":"1"
      }
   }
}
```

RequestMethod GET para a URL: http://localhost:8080/api/pagamento/{id} - Retorna um pagamento específico a partir  do "id" da transação.

RequestMethod PUT para a URL: http://localhost:8080/api/pagamento/{id} - Realiza o estorno de um pagamento específico a partir do "id" da transação.
