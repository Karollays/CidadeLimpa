package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.dto.ImovelCadastroDto;
import br.com.fiap.cidadelimpa.dto.ImovelExibicaoDto;
import br.com.fiap.cidadelimpa.service.ImovelService;
import jakarta.validation.Valid;
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
    public ImovelExibicaoDto salvar(@RequestBody @Valid ImovelCadastroDto imovelCadastroDto) {
        return imovelService.salvar(imovelCadastroDto);
    }

    @GetMapping("/imoveis/{imovelId}")
    @ResponseStatus(HttpStatus.OK)
    public ImovelExibicaoDto buscar(@PathVariable Long imovelId) {
        return imovelService.buscar(imovelId);
    }

    @GetMapping("/imoveis")
    @ResponseStatus(HttpStatus.OK)
    public List<ImovelExibicaoDto> listarImoveis() {
        return imovelService.listarImoveis();
    }

    @PutMapping("/imoveis")
    public ImovelExibicaoDto atualizar(@RequestBody @Valid ImovelCadastroDto imovelCadastroDto) {
        return imovelService.atualizar(imovelCadastroDto);
    }

    @DeleteMapping("/imoveis/{imovelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long imovelId) {
        imovelService.deletar(imovelId);
    }

    @GetMapping(value = "/imoveis", params = "bairro")
    @ResponseStatus(HttpStatus.OK)
    public List<ImovelExibicaoDto> buscarBairro(@RequestParam String bairro) {
        return imovelService.buscarBairro(bairro);
    }

    @PostMapping("/imoveis/lixo")
    @ResponseStatus(HttpStatus.OK)
    public void gerarLixo() {
        imovelService.gerarLixo();
    }
}
