package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping("/imoveis")
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel salvar(@RequestBody Imovel imovel) {
        return imovelService.salvar(imovel);
    }

    @GetMapping("/imoveis/{imovelId}")
    public Imovel buscar(@PathVariable Long imovelId) {
        return imovelService.buscar(imovelId);
    }

    @GetMapping("/imoveis")
    @ResponseStatus(HttpStatus.OK)
    public List<Imovel> listarImoveis() {
        return imovelService.listarImoveis();
    }

    @PutMapping("/imoveis")
    @ResponseStatus(HttpStatus.OK)
    public Imovel atualizar(@RequestBody Imovel imovel) {
        return imovelService.atualizar(imovel);
    }

    @DeleteMapping("/imoveis/{imovelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long imovelId) {
        imovelService.deletar(imovelId);
    }
}
