package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.model.Morador;
import br.com.fiap.cidadelimpa.service.MoradorService;
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
    public Morador salvar(@RequestBody Morador morador) {
        return moradorService.salvar(morador);
    }

    @GetMapping("/moradores/{moradorId}")
    public Morador buscar(@PathVariable Long moradorId) {
        return moradorService.buscar(moradorId);
    }

    @GetMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public List<Morador> listarMoradores() {
        return moradorService.listarMoradores();
    }

    @PutMapping("/moradores")
    @ResponseStatus(HttpStatus.OK)
    public Morador atualizar(@RequestBody Morador morador) {
        return moradorService.atualizar(morador);
    }

    @DeleteMapping("/moradores/{moradorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long moradorId) {
        moradorService.deletar(moradorId);
    }
}
