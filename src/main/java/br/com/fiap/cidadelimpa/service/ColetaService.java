package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.ColetaExibicaoDto;
import br.com.fiap.cidadelimpa.dto.ColetaCadastroDto;
import br.com.fiap.cidadelimpa.exception.CaminhaoNaoExisteException;
import br.com.fiap.cidadelimpa.exception.ColetaNaoExisteException;
import br.com.fiap.cidadelimpa.exception.ImovelNaoExisteException;
import br.com.fiap.cidadelimpa.model.Caminhao;
import br.com.fiap.cidadelimpa.model.Coleta;
import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.repository.CaminhaoRepository;
import br.com.fiap.cidadelimpa.repository.ColetaRepository;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;
    @Autowired
    private CaminhaoRepository caminhaoRepository;
    @Autowired
    private ImovelRepository imovelRepository;

    public ColetaExibicaoDto salvar(ColetaCadastroDto coletaCadastroDto) {
        Coleta coleta = new Coleta();
        BeanUtils.copyProperties(coletaCadastroDto, coleta);
        Caminhao caminhao = caminhaoRepository.findById(coletaCadastroDto.caminhaoId())
                .orElseThrow(() -> new CaminhaoNaoExisteException("Caminhão não encontrado"));
        coleta.setCaminhao(caminhao);
        Imovel imovel = imovelRepository.findById(coletaCadastroDto.imovelId())
                .orElseThrow(() -> new ImovelNaoExisteException("Imóvel não encontrado"));
        coleta.setImovel(imovel);
        return new ColetaExibicaoDto(coletaRepository.save(coleta));
    }

    public ColetaExibicaoDto buscar(Long id) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            return new ColetaExibicaoDto(coletaOptional.get());
        } else {
            throw new ColetaNaoExisteException("Coleta não encontrada.");
        }
    }

    public List<ColetaExibicaoDto> listarColetas() {
        return coletaRepository
                .findAll()
                .stream()
                .map(ColetaExibicaoDto::new)
                .toList();
    }

    public ColetaExibicaoDto atualizar(ColetaCadastroDto coletaCadastroDto) {
        Coleta coleta = coletaRepository.findById(coletaCadastroDto.id())
                .orElseThrow(() -> new ColetaNaoExisteException("Coleta não encontrada."));
        BeanUtils.copyProperties(coletaCadastroDto, coleta);
        Caminhao caminhao = caminhaoRepository.findById(coletaCadastroDto.caminhaoId())
                .orElseThrow(() -> new CaminhaoNaoExisteException("Caminhão não encontrado"));
        coleta.setCaminhao(caminhao);
        Imovel imovel = imovelRepository.findById(coletaCadastroDto.imovelId())
                .orElseThrow(() -> new ImovelNaoExisteException("Imovel não encontrado"));
        coleta.setImovel(imovel);
        return new ColetaExibicaoDto(coletaRepository.save(coleta));
    }

    public void deletar(Long id) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            coletaRepository.delete(coletaOptional.get());
        } else {
            throw new ColetaNaoExisteException("Coleta não encontrada.");
        }
    }
}