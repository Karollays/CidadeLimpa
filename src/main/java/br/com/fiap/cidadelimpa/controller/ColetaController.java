package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.dto.ColetaCadastroDto;
import br.com.fiap.cidadelimpa.dto.ColetaExibicaoDto;
import br.com.fiap.cidadelimpa.service.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColetaController {

    @Autowired
    private ColetaService coletaService;

    @PostMapping("/coletas")
    @ResponseStatus(HttpStatus.CREATED)
    public ColetaExibicaoDto salvar(@RequestBody @Valid ColetaCadastroDto coletaCadastroDto) {
        return coletaService.salvar(coletaCadastroDto);
    }

    @GetMapping("/coletas/{coletaId}")
    @ResponseStatus(HttpStatus.OK)
    public ColetaExibicaoDto buscar(@PathVariable Long coletaId) {
        return coletaService.buscar(coletaId);
    }

    @GetMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public List<ColetaExibicaoDto> listarColetas() {
        return coletaService.listarColetas();
    }

    @PutMapping("/coletas")
    public ColetaExibicaoDto atualizar(@RequestBody @Valid ColetaCadastroDto coletaCadastroDto) {
        return coletaService.atualizar(coletaCadastroDto);
    }

    @DeleteMapping("/coletas/{coletaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long coletaId) {
        coletaService.deletar(coletaId);
    }
}
