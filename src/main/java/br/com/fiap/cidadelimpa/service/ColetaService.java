package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.model.Coleta;
import br.com.fiap.cidadelimpa.repository.ColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository coletaRepository;

    public Coleta salvar(Coleta coleta) {
        return coletaRepository.save(coleta);
    }

    public Coleta buscar(Long id) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            return coletaOptional.get();
        } else {
            throw new RuntimeException("Coleta não encontrada.");
        }
    }

    public List<Coleta> listarColetas() {
        return coletaRepository.findAll();
    }

    public Coleta atualizar(Coleta coleta){
        Optional<Coleta> coletaOptional = coletaRepository.findById(coleta.getId());
        if (coletaOptional.isPresent()){
            return coletaRepository.save(coleta);
        } else {
            throw new RuntimeException("Coleta não encontrada.");
        }
    }

    public void deletar(Long id) {
        Optional<Coleta> coletaOptional = coletaRepository.findById(id);
        if (coletaOptional.isPresent()) {
            coletaRepository.delete(coletaOptional.get());
        } else {
            throw new RuntimeException("Coleta não encontrada.");
        }
    }
}