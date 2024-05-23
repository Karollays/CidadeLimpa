package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.model.Imovel;
import br.com.fiap.cidadelimpa.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel salvar(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public Imovel buscar(Long id) {
        Optional<Imovel> imovelOptional = imovelRepository.findById(id);
        if (imovelOptional.isPresent()) {
            return imovelOptional.get();
        } else {
            throw new RuntimeException("Imóvel não encontrado.");
        }
    }

    public List<Imovel> listarImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel atualizar(Imovel imovel ){
        Optional<Imovel> imovelOptional = imovelRepository.findById(imovel.getId());
        if (imovelOptional.isPresent()){
            return imovelRepository.save(imovel);
        } else {
            throw new RuntimeException("Imóvel não encontrado.");
        }
    }

    public void deletar(Long id) {
        Optional<Imovel> imovelOptional = imovelRepository.findById(id);
        if (imovelOptional.isPresent()) {
            imovelRepository.delete(imovelOptional.get());
        } else {
            throw new RuntimeException("Imóvel não encontrado.");
        }
    }
}