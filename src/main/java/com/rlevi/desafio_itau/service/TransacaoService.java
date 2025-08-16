package com.rlevi.desafio_itau.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rlevi.desafio_itau.dto.TransacaoDTO;
import com.rlevi.desafio_itau.exceptions.UnprocessableEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacao(TransacaoDTO transacao) {

        log.info("Adicionando transação");

        if(transacao.valor() <=0) {
            log.info("Valor da transação não pode ser negativo");
            throw new UnprocessableEntity("Valor da transação não pode ser negativo");
        } else if(transacao.dataHora().isAfter(OffsetDateTime.now())) {
            log.info("Data da transação não pode ser futura");
            throw new UnprocessableEntity("Data da transação não pode ser futura");
        }

        listaTransacoes.add(transacao);
    }

    public void limparTransacao() {
        log.info("Limpar transação");
        listaTransacoes.clear();
    }

    public List<TransacaoDTO> buscarTransacao(Integer intervalo) {
        OffsetDateTime dataIntervalo = OffsetDateTime.now().minusSeconds(intervalo);

        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataIntervalo))
                .toList();
    }
}
