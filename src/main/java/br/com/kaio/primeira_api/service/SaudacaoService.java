package br.com.kaio.primeira_api.service;

import org.springframework.stereotype.Service;

@Service
public class SaudacaoService {
    public String formatarSaudacao(String nome) {
        if(nome == null || nome.isBlank()) {
            return "Ola, Mundo!";
        }
        return "Ola, " + nome + "! Bem-vindo ao spring.";
    }
}
