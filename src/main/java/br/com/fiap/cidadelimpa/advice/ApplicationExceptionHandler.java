package br.com.fiap.cidadelimpa.advice;

import br.com.fiap.cidadelimpa.exception.CaminhaoNaoExisteException;
import br.com.fiap.cidadelimpa.exception.ColetaNaoExisteException;
import br.com.fiap.cidadelimpa.exception.ImovelNaoExisteException;
import br.com.fiap.cidadelimpa.exception.MoradorNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException error) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", "Erro de leitura da mensagem HTTP: " + error.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();
        for (FieldError campo : campos) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CaminhaoNaoExisteException.class)
    public Map<String, String> handleCaminhaoNaoExiste(CaminhaoNaoExisteException error) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", error.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ColetaNaoExisteException.class)
    public Map<String, String> handleColetaNaoExiste(ColetaNaoExisteException error) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", error.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ImovelNaoExisteException.class)
    public Map<String, String> handleImovelNaoExiste(ImovelNaoExisteException error) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", error.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MoradorNaoExisteException.class)
    public Map<String, String> handleMoradorNaoExiste(MoradorNaoExisteException error) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", error.getMessage());
        return errorMap;
    }
}