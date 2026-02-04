package br.com.kaio.primeira_api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class ErrorHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErroDeValidacao(MethodArgumentNotValidException ex) {

        System.out.println(">>> OPA! O PROTETOR DE ERROS FOI ACIONADO! <<<")
        ;
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeDoCampo = ((FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();

            errors.put(nomeDoCampo, mensagemDeErro);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
