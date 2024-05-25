package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.CaminhaoExibicaoDto;
import br.com.fiap.cidadelimpa.dto.CaminhaoCadastroDto;
import br.com.fiap.cidadelimpa.exception.CaminhaoNaoExisteException;
import br.com.fiap.cidadelimpa.exception.ImovelNaoExisteException;
import br.com.fiap.cidadelimpa.exception.ImovelSemLixoException;
import br.com.fiap.cidadelimpa.model.Caminhao;
import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.repository.CaminhaoRepository;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;
    @Autowired
    private ImovelRepository imovelRepository;

    public CaminhaoExibicaoDto salvar(CaminhaoCadastroDto caminhaoCadastroDto) {
        Caminhao caminhao = new Caminhao();
        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);
        return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
    }

    public CaminhaoExibicaoDto buscar(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);
        if (caminhaoOptional.isPresent()) {
            return new CaminhaoExibicaoDto(caminhaoOptional.get());
        } else {
            throw new CaminhaoNaoExisteException("Caminhao não encontrado.");
        }
    }

    public List<CaminhaoExibicaoDto> listarCaminhoes() {
        return caminhaoRepository
                .findAll()
                .stream()
                .map(CaminhaoExibicaoDto::new)
                .toList();
    }

    public CaminhaoExibicaoDto atualizar(CaminhaoCadastroDto caminhaoCadastroDto) {
        Caminhao caminhao = caminhaoRepository.findById(caminhaoCadastroDto.id())
                .orElseThrow(() -> new CaminhaoNaoExisteException("Caminhão não encontrado."));
        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);
        return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
    }

    public void deletar(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);
        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new CaminhaoNaoExisteException("Caminhão não encontrado.");
        }
    }
}