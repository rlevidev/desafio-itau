package com.rlevi.desafio_itau.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rlevi.desafio_itau.dto.EstatisticaDTO;
import com.rlevi.desafio_itau.service.EstatisticasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {
    private final EstatisticasService estatisticasService;

    @GetMapping()
    public ResponseEntity<EstatisticaDTO> calcularEstatisticas(
        @RequestParam(value = "intervalo", required = false, defaultValue = "60") Integer intervalo) {
        return ResponseEntity.ok(estatisticasService.calcularEstatisticas(intervalo));
    }
}