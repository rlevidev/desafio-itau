package com.rlevi.desafio_itau.service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rlevi.desafio_itau.dto.EstatisticaDTO;
import com.rlevi.desafio_itau.dto.TransacaoDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstatisticasService {

    private final TransacaoService transacaoService;

    public EstatisticaDTO calcularEstatisticas(Integer intervalo) {
        List<TransacaoDTO> transacao = transacaoService.buscarTransacao(intervalo);
        DoubleSummaryStatistics estatisticasTransacao = transacao.stream().mapToDouble(TransacaoDTO::valor).summaryStatistics();

        return new EstatisticaDTO(estatisticasTransacao.getCount(), estatisticasTransacao.getSum(), estatisticasTransacao.getAverage(), estatisticasTransacao.getMin(), estatisticasTransacao.getMax());
    }
}
