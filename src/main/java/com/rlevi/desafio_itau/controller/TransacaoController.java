package com.rlevi.desafio_itau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlevi.desafio_itau.dto.TransacaoDTO;
import com.rlevi.desafio_itau.service.TransacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping()
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoDTO transacao) {
        transacaoService.adicionarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping()
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.limparTransacao();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
