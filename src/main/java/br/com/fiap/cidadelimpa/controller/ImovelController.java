package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.dto.ImovelCadastroDto;
import br.com.fiap.cidadelimpa.dto.ImovelExibicaoDto;
import br.com.fiap.cidadelimpa.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/imoveis")
    public ImovelExibicaoDto atualizar(@RequestBody @Valid ImovelCadastroDto imovelCadastroDto) {
        return imovelService.atualizar(imovelCadastroDto);
    }

    @DeleteMapping("/imoveis/{imovelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long imovelId) {
        imovelService.deletar(imovelId);
    }

    @GetMapping("/imoveis")
    @ResponseStatus(HttpStatus.OK)
    public Page<ImovelExibicaoDto> listarImoveis(Pageable paginacao) {
        return imovelService.listarImoveis(paginacao);
    }

    @GetMapping(value = "/imoveis", params = "bairro")
    @ResponseStatus(HttpStatus.OK)
    public Page<ImovelExibicaoDto> buscarBairro(
            @RequestParam String bairro,
            Pageable paginacao) {
        return imovelService.buscarBairro(bairro, paginacao);
    }

    @PostMapping("/imoveis/lixo")
    @ResponseStatus(HttpStatus.OK)
    public void gerarLixo() {
        imovelService.gerarLixo();
    }
}
