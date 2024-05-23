package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.model.Morador;
import br.com.fiap.cidadelimpa.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public Morador salvar(Morador morador) {
        return moradorRepository.save(morador);
    }

    public Morador buscar(Long id) {
        Optional<Morador> moradorOptional = moradorRepository.findById(id);
        if (moradorOptional.isPresent()) {
            return moradorOptional.get();
        } else {
            throw new RuntimeException("Morador não encontrado.");
        }
    }

    public List<Morador> listarMoradores() {
        return moradorRepository.findAll();
    }

    public Morador atualizar(Morador morador) {
        Optional<Morador> moradorOptional = moradorRepository.findById(morador.getId());
        if (moradorOptional.isPresent()) {
            return moradorRepository.save(morador);
        } else {
            throw new RuntimeException("Morador não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Morador> moradorOptional = moradorRepository.findById(id);
        if (moradorOptional.isPresent()) {
            moradorRepository.delete(moradorOptional.get());
        } else {
            throw new RuntimeException("Morador não encontrado.");
        }
    }
}
