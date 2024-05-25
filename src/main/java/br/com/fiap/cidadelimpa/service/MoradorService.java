package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.MoradorCadastroDto;
import br.com.fiap.cidadelimpa.dto.MoradorExibicaoDto;
import br.com.fiap.cidadelimpa.exception.ImovelNaoExisteException;
import br.com.fiap.cidadelimpa.exception.MoradorNaoExisteException;
import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.model.Morador;
import br.com.fiap.cidadelimpa.repository.MoradorRepository;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;
    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional
    public MoradorExibicaoDto salvar(MoradorCadastroDto moradorCadastroDto) {
        Morador morador = new Morador();
        BeanUtils.copyProperties(moradorCadastroDto, morador);
        Imovel imovel = imovelRepository.findById(moradorCadastroDto.imovelId())
                .orElseThrow(() -> new MoradorNaoExisteException("Imovel não encontrado"));

        morador.setImovel(imovel);
        return new MoradorExibicaoDto(moradorRepository.save(morador));
    }

    @Transactional(readOnly = true)
    public MoradorExibicaoDto buscar(Long id) {
        Optional<Morador> moradorOptional = moradorRepository.findById(id);
        if (moradorOptional.isPresent()) {
            return new MoradorExibicaoDto(moradorOptional.get());
        } else {
            throw new MoradorNaoExisteException("Morador não encontrado.");
        }
    }

    @Transactional
    public MoradorExibicaoDto atualizar(MoradorCadastroDto moradorCadastroDto) {
        Morador morador = moradorRepository.findById(moradorCadastroDto.id())
                .orElseThrow(() -> new MoradorNaoExisteException("Morador não encontrado."));
        BeanUtils.copyProperties(moradorCadastroDto, morador);

        Imovel imovel = imovelRepository.findById(moradorCadastroDto.imovelId())
                .orElseThrow(() -> new ImovelNaoExisteException("Imovel não encontrado"));
        morador.setImovel(imovel);
        return new MoradorExibicaoDto(moradorRepository.save(morador));
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Morador> moradorOptional = moradorRepository.findById(id);
        if (moradorOptional.isPresent()) {
            moradorRepository.delete(moradorOptional.get());
        } else {
            throw new MoradorNaoExisteException("Morador não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public List<MoradorExibicaoDto> listarMoradores() {
        return moradorRepository
                .findAll()
                .stream()
                .map(MoradorExibicaoDto::new)
                .toList();
    }
}
