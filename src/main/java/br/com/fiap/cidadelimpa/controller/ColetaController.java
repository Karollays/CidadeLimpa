package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.model.Coleta;
import br.com.fiap.cidadelimpa.service.ColetaService;
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
    public Coleta salvar(@RequestBody Coleta coleta) {
        return coletaService.salvar(coleta);
    }

    @GetMapping("/coletas/{coletaId}")
    public Coleta buscar(@PathVariable Long coletaId) {
        return coletaService.buscar(coletaId);
    }

    @GetMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public List<Coleta> listarColetas() {
        return coletaService.listarColetas();
    }

    @PutMapping("/coletas")
    @ResponseStatus(HttpStatus.OK)
    public Coleta atualizar(@RequestBody Coleta coleta) {
        return coletaService.atualizar(coleta);
    }

    @DeleteMapping("/coletas/{coletaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long coletaId) {
        coletaService.deletar(coletaId);
    }
}
