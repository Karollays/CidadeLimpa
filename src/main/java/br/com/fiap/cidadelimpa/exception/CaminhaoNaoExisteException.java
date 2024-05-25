package br.com.fiap.cidadelimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CaminhaoNaoExisteException extends RuntimeException {
    public CaminhaoNaoExisteException(String mensagem) {
        super(mensagem);
    }
}
