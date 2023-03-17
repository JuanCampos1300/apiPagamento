package com.apipagamentos.apipagamentos.controller;

import com.apipagamentos.apipagamentos.dto.request.PagamentoDTO;
import com.apipagamentos.apipagamentos.dto.response.PagamentoResponseDTO;
import com.apipagamentos.apipagamentos.model.Pagamento;
import com.apipagamentos.apipagamentos.services.ServicePagamento;
import com.apipagamentos.apipagamentos.util.CustomErrorType;
import io.swagger.annotations.Api;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Endpoints relacionados aos pagamentos
 */
@Api(value = "API REST PAGAMENTO")
@RestController
@RequestMapping("/api")
public class PagamentoController {

    @Autowired
    ServicePagamento pagamentoService;

    /**
     * Lista todos pagamentos
     *
     * @return
     */
    @GetMapping(value = "/pagamento")
    public ResponseEntity<List<PagamentoResponseDTO>> listResponseEntity() {
        List<PagamentoResponseDTO> pagamentos = pagamentoService.findAll();
        if (pagamentos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PagamentoResponseDTO>>(pagamentos, HttpStatus.OK);
    }

    /**
     * Buscando pagamento por Id
     *
     * @param idTransacao
     * @return
     */
    @GetMapping(value = "/pagamento/{idTransacao}")
    public ResponseEntity<?> getPagamento(@PathVariable("idTransacao") long idTransacao) {

        PagamentoResponseDTO pagamento = pagamentoService.findPagDtoByTransacao(idTransacao);
        if (pagamento == null) {
            return new ResponseEntity(new CustomErrorType("Pagamento não encontrado"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PagamentoResponseDTO>(pagamento, HttpStatus.OK);
    }

    /**
     * Atualiza pagamento por id
     *
     * @param idTransacao
     * @return
     */
    @PutMapping(value = "/pagamento/{idTransacao}")
    public ResponseEntity<PagamentoResponseDTO> updatePagamento(@PathVariable("idTransacao") long idTransacao) {
        Pagamento pagamento = pagamentoService.findPagByTransacao(idTransacao);
        if (pagamento == null) {
            return new ResponseEntity(new CustomErrorType("Pagamento não encontrado"), HttpStatus.NOT_FOUND);
        }
        PagamentoResponseDTO pagamentoResponseDTO = pagamentoService.estorno(pagamento);
        return new ResponseEntity<PagamentoResponseDTO>(pagamentoResponseDTO, HttpStatus.OK);
    }

    /**
     * Cria pagamento
     *
     * @param pagamentoDto
     * @return
     */
    @PostMapping(value = "/pagamento")
    public ResponseEntity<PagamentoResponseDTO> creatpayment(@Valid @RequestBody PagamentoDTO pagamentoDto) {
        try {

            PagamentoResponseDTO pagDto = pagamentoService.insert(pagamentoDto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/api/pagamento/{idTransacao}")
                    .buildAndExpand(pagDto.getTransacao().getId()).toUri();
            return ResponseEntity.created(uri).body(pagDto);

        } catch (ServiceException e) {
            return new ResponseEntity(new CustomErrorType("Transação existente"), HttpStatus.CONFLICT);
        }
    }
}

