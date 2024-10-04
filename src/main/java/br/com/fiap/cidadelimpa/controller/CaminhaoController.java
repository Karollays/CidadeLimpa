package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.dto.CaminhaoCadastroDto;
import br.com.fiap.cidadelimpa.dto.CaminhaoExibicaoDto;
import br.com.fiap.cidadelimpa.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhoes")
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhaoExibicaoDto salvar(@RequestBody @Valid CaminhaoCadastroDto caminhaoCadastroDto) {
        return caminhaoService.salvar(caminhaoCadastroDto);
    }

    @GetMapping("/caminhoes/{caminhaoId}")
    @ResponseStatus(HttpStatus.OK)
    public CaminhaoExibicaoDto buscar(@PathVariable Long caminhaoId) {
        return caminhaoService.buscar(caminhaoId);
    }

    @PutMapping("/caminhoes")
    public CaminhaoExibicaoDto atualizar(@RequestBody @Valid CaminhaoCadastroDto caminhaoCadastroDto) {
        return caminhaoService.atualizar(caminhaoCadastroDto);
    }

    @DeleteMapping("/caminhoes/{caminhaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long caminhaoId) {
        caminhaoService.deletar(caminhaoId);
    }

    @GetMapping("/caminhoes")
    @ResponseStatus(HttpStatus.OK)
    public Page<CaminhaoExibicaoDto> litarCaminhoes(Pageable paginacao) {
        return caminhaoService.listarCaminhoes(paginacao);
    }

    @PostMapping("/caminhoes/descarregar")
    @ResponseStatus(HttpStatus.OK)
    public void descarregarCaminhoes() {
        caminhaoService.descarregarCaminhoes();
    }

    @PostMapping("/caminhoes/{idCaminhao}/retirar-lixo/{idImovel}/{tipoColeta}")
    public void retirarLixoDoImovel(@PathVariable Long idCaminhao, @PathVariable Long idImovel, @PathVariable String tipoColeta) {
        caminhaoService.retirarLixo(idCaminhao, idImovel, tipoColeta);
    }
}