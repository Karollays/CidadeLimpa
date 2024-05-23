package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.model.Caminhao;
import br.com.fiap.cidadelimpa.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Caminhao salvar(Caminhao caminhao) {
        return caminhaoRepository.save(caminhao);
    }

    public Caminhao buscar(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);
        if (caminhaoOptional.isPresent()) {
            return caminhaoOptional.get();
        } else {
            throw new RuntimeException("Caminhão não encontrado.");
        }
    }

    public List<Caminhao> listarCaminhoes() {
        return caminhaoRepository.findAll();
    }

    public Caminhao atualizar(Caminhao caminhao){
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(caminhao.getId());
        if (caminhaoOptional.isPresent()){
            return caminhaoRepository.save(caminhao);
        } else {
            throw new RuntimeException("Caminhão não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);
        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Caminhão não encontrado.");
        }
    }
}