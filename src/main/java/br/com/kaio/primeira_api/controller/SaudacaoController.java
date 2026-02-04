package br.com.kaio.primeira_api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kaio.primeira_api.dto.StatusResponse;
import br.com.kaio.primeira_api.service.SaudacaoService;

@RestController
public class SaudacaoController {
    private final SaudacaoService saudacaoService;

    public SaudacaoController(SaudacaoService saudacaoService) {
        this.saudacaoService = saudacaoService;
    }

    @GetMapping("/api/saudacao")
    public StatusResponse saudar(@RequestParam(required = false) String nome) {
        String mensagemFormatada = saudacaoService.formatarSaudacao(nome);

        return new StatusResponse("sucesso", mensagemFormatada, "Sistema");
    }
}