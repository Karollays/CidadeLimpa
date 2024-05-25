package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.dto.MoradorCadastroDto;
import br.com.fiap.cidadelimpa.dto.MoradorExibicaoDto;
import br.com.fiap.cidadelimpa.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping("/moradores")
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorExibicaoDto salvar(@RequestBody @Valid MoradorCadastroDto moradorCadastroDto) {
        return moradorService.salvar(moradorCadastroDto);
    }

    @GetMapping("/moradores/{moradorId}")
    @ResponseStatus(HttpStatus.OK)
    public MoradorExibicaoDto buscar(@PathVariable Long moradorId) {
        return moradorService.buscar(moradorId);
    }

    @GetMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public List<MoradorExibicaoDto> litarMoradores() {
        return moradorService.listarMoradores();
    }

    @PutMapping("/moradores")
    public MoradorExibicaoDto atualizar(@RequestBody @Valid MoradorCadastroDto moradorCadastroDto) {
        return moradorService.atualizar(moradorCadastroDto);
    }

    @DeleteMapping("/moradores/{moradorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long moradorId) {
        moradorService.deletar(moradorId);
    }
}
