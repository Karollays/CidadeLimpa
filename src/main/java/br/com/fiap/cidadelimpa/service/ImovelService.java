package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.ImovelCadastroDto;
import br.com.fiap.cidadelimpa.dto.ImovelExibicaoDto;
import br.com.fiap.cidadelimpa.exception.ImovelNaoExisteException;
import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<ImovelExibicaoDto> listarImoveis(Pageable paginacao) {
        return imovelRepository
                .findAll(paginacao)
                .map(ImovelExibicaoDto::new);
    }

    @Transactional(readOnly = true)
    public Page<ImovelExibicaoDto> buscarBairro(String bairro, Pageable paginacao) {
        Page<Imovel> imoveis = imovelRepository.buscarBairro(bairro, paginacao);
        if (imoveis.isEmpty()) {
            throw new ImovelNaoExisteException("Nenhum imóvel encontrado no bairro");
        }
        List<ImovelExibicaoDto> imoveisDto = imoveis.getContent().stream()
                .map(ImovelExibicaoDto::new)
                .collect(Collectors.toList());
        return new PageImpl<>(imoveisDto, paginacao, imoveis.getTotalElements());
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