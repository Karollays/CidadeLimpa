package br.com.fiap.cidadelimpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ImovelSemLixoException extends IllegalArgumentException {
    public ImovelSemLixoException(String mensagem) {
        super(mensagem);
    }
}