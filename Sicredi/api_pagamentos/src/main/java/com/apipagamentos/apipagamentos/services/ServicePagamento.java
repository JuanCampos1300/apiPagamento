package com.apipagamentos.apipagamentos.services;

import com.apipagamentos.apipagamentos.dto.request.PagamentoDTO;
import com.apipagamentos.apipagamentos.dto.response.PagamentoResponseDTO;
import com.apipagamentos.apipagamentos.enums.Status;
import com.apipagamentos.apipagamentos.model.Pagamento;
import com.apipagamentos.apipagamentos.model.Transacao;
import com.apipagamentos.apipagamentos.repository.PagamentoRepository;
import com.apipagamentos.apipagamentos.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Juan Campos do Nascimento
 * @email juan.nascimento@tools.com.br
 * @description Serviços relacionados a pagamento
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicePagamento {

    private PagamentoRepository pagamentoRepository;
    private TransacaoRepository transacaoRepository;
    private ModelMapper mapper;

    /**
     * Retorna uma lista de pagamentos
     *
     * @return pagamentoResoinseDTOS
     */
    public List<PagamentoResponseDTO> findAll() {
        List<Pagamento> list_pagamentos = pagamentoRepository.findAll();

        List<PagamentoResponseDTO> pagamentoResponseDTOS = new ArrayList<>();
        for (Pagamento pag : list_pagamentos) {
            pagamentoResponseDTOS.add(mapper.map(pag, PagamentoResponseDTO.class));
        }
        return pagamentoResponseDTOS;
    }

    /**
     * Retorna uma lista de pagamento por ID
     *
     * @param id
     * @return
     */
    public PagamentoResponseDTO findPagDtoByTransacao(Long id) {
        List<Pagamento> list_pagamentos = pagamentoRepository.findAll();
        for (Pagamento pag : list_pagamentos) {
            if (pag.getTransacao().getId().equals(id))
                return mapper.map(pag, PagamentoResponseDTO.class);
        }
        return null;
    }

    /**
     * Busca pagamento por ID
     *
     * @param id
     * @return
     */
    public Pagamento findPagByTransacao(Long id) {
        List<Pagamento> list_pagamentos = pagamentoRepository.findAll();
        for (Pagamento pag : list_pagamentos) {
            if (pag.getTransacao().getId().equals(id))
                return pag;
        }
        return null;
    }

    /**
     * Busca estorno por pagamento
     *
     * @param pagamento
     * @return
     */
    public PagamentoResponseDTO estorno(Pagamento pagamento) {

        pagamento.getTransacao().getDescricao().setStatus(Status.NEGADO);
        pagamentoRepository.save(pagamento);
        PagamentoResponseDTO pagamentoResponseDTO = mapper.map(pagamento, PagamentoResponseDTO.class);

        return pagamentoResponseDTO;
    }

    /**
     * Método para inserir pagamento
     *
     * @param pagamentoDTO
     * @return
     */
    public PagamentoResponseDTO insert(PagamentoDTO pagamentoDTO) {

        Optional<Transacao> transacao = transacaoRepository.findById(pagamentoDTO.getTransacao().getId());
        if (transacao.isPresent()) {
            throw new ServiceException("Transação já existe");
        }

        Pagamento pagamento = mapper.map(pagamentoDTO, Pagamento.class);
        pagamento.getTransacao().getDescricao().setNsu(239484882);
        pagamento.getTransacao().getDescricao().setCodigoAutorizacao(32332323);
        pagamento.getTransacao().getDescricao().setStatus(Status.AUTORIZADO);

        pagamentoRepository.save(pagamento);

        PagamentoResponseDTO pagamentoResponseDTO = mapper.map(pagamento, PagamentoResponseDTO.class);
        return pagamentoResponseDTO;
    }

    /**
     * Método para atualizar pagamento
     *
     * @param pagamento
     */
    public void update(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }
}
