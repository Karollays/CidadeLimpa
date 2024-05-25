package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.ImovelCadastroDto;
import br.com.fiap.cidadelimpa.dto.ImovelExibicaoDto;
import br.com.fiap.cidadelimpa.exception.ImovelNaoExisteException;
import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional
    public ImovelExibicaoDto salvar(ImovelCadastroDto imovelCadastroDto) {
        Imovel imovel = new Imovel();
        BeanUtils.copyProperties(imovelCadastroDto, imovel);
        return new ImovelExibicaoDto(imovelRepository.save(imovel));
    }

    @Transactional(readOnly = true)
    public ImovelExibicaoDto buscar(Long id) {
        Optional<Imovel> imovelOptional = imovelRepository.findById(id);
        if (imovelOptional.isPresent()) {
            return new ImovelExibicaoDto(imovelOptional.get());
        } else {
            throw new ImovelNaoExisteException("Imóvel não encontrado.");
        }
    }

    @Transactional
    public ImovelExibicaoDto atualizar(ImovelCadastroDto imovelCadastroDto) {
        Imovel imovel = imovelRepository.findById(imovelCadastroDto.id())
                .orElseThrow(() -> new ImovelNaoExisteException("Imóvel não encontrado."));
        BeanUtils.copyProperties(imovelCadastroDto, imovel);
        return new ImovelExibicaoDto(imovelRepository.save(imovel));
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Imovel> imovelOptional = imovelRepository.findById(id);
        if (imovelOptional.isPresent()) {
            imovelRepository.delete(imovelOptional.get());
        } else {
            throw new ImovelNaoExisteException("Imóvel não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public List<ImovelExibicaoDto> listarImoveis() {
        return imovelRepository
                .findAll()
                .stream()
                .map(ImovelExibicaoDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ImovelExibicaoDto> buscarBairro(String bairro) {
        List<Imovel> imoveis = imovelRepository.buscarBairro(bairro);
        if (imoveis.isEmpty()) {
            throw new ImovelNaoExisteException("Nenhum imóvel encontrado no bairro");
        }
        return imoveis.stream().map(ImovelExibicaoDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void gerarLixo() {
        List<Imovel> imoveis = imovelRepository.findAll();
        Random aleatorio = new Random();
        for (Imovel imovel : imoveis) {
            double organico = Math.round(aleatorio.nextDouble() * 10000) / 100.0;
            double reciclavel = Math.round(aleatorio.nextDouble() * 10000) / 100.0;
            imovel.setOrganico(organico);
            imovel.setReciclavel(reciclavel);
            imovelRepository.save(imovel);
        }
    }
}