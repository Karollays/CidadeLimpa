package br.com.fiap.cidadelimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MoradorNaoExisteException extends RuntimeException {
    public MoradorNaoExisteException(String mensagem) {
        super(mensagem);
    }
}