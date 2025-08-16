package com.rlevi.desafio_itau.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(Double valor, OffsetDateTime dataHora) {
}
