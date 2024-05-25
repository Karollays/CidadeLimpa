package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.CaminhaoExibicaoDto;
import br.com.fiap.cidadelimpa.dto.CaminhaoCadastroDto;
import br.com.fiap.cidadelimpa.exception.CaminhaoNaoExisteException;
import br.com.fiap.cidadelimpa.model.Caminhao;
import br.com.fiap.cidadelimpa.repository.CaminhaoRepository;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;
    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional
    public CaminhaoExibicaoDto salvar(CaminhaoCadastroDto caminhaoCadastroDto) {
        Caminhao caminhao = new Caminhao();
        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);
        return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
    }

    @Transactional(readOnly = true)
    public CaminhaoExibicaoDto buscar(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);
        if (caminhaoOptional.isPresent()) {
            return new CaminhaoExibicaoDto(caminhaoOptional.get());
        } else {
            throw new CaminhaoNaoExisteException("Caminhao não encontrado.");
        }
    }

    @Transactional
    public CaminhaoExibicaoDto atualizar(CaminhaoCadastroDto caminhaoCadastroDto) {
        Caminhao caminhao = caminhaoRepository.findById(caminhaoCadastroDto.id())
                .orElseThrow(() -> new CaminhaoNaoExisteException("Caminhão não encontrado."));
        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);
        return new CaminhaoExibicaoDto(caminhaoRepository.save(caminhao));
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);
        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new CaminhaoNaoExisteException("Caminhão não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public List<CaminhaoExibicaoDto> listarCaminhoes() {
        return caminhaoRepository
                .findAll()
                .stream()
                .map(CaminhaoExibicaoDto::new)
                .toList();
    }

    @Transactional
    public void descarregarCaminhoes() {
        List<Caminhao> caminhoes = caminhaoRepository.findAll();
        for (Caminhao caminhao : caminhoes) {
            caminhao.setCapacidade(0.0);
        }
        caminhaoRepository.saveAll(caminhoes);
    }
}