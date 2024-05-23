package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.model.Caminhao;
import br.com.fiap.cidadelimpa.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhoes")
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao salvar(@RequestBody Caminhao caminhao) {
        return caminhaoService.salvar(caminhao);
    }

    @GetMapping("/caminhoes/{caminhaoId}")
    public Caminhao buscar(@PathVariable Long caminhaoId) {
        return caminhaoService.buscar(caminhaoId);
    }

    @GetMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public List<Caminhao> listarCaminhoes() {
        return caminhaoService.listarCaminhoes();
    }

    @PutMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public Caminhao atualizar(@RequestBody Caminhao caminhao) {
        return caminhaoService.atualizar(caminhao);
    }

    @DeleteMapping("/caminhoes/{caminhaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long caminhaoId) {
        caminhaoService.deletar(caminhaoId);
    }
}
