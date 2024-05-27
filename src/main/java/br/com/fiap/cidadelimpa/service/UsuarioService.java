package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.UsuarioCadastroDto;
import br.com.fiap.cidadelimpa.dto.UsuarioExibicaoDto;
import br.com.fiap.cidadelimpa.exception.UsuarioNaoExisteException;
import br.com.fiap.cidadelimpa.model.Usuario;
import br.com.fiap.cidadelimpa.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @Autowired
//    private ImovelRepository imovelRepository;

    @Transactional
    public UsuarioExibicaoDto salvar(UsuarioCadastroDto usuarioCadastroDto) {

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);

//        Imovel imovel = imovelRepository.findById(moradorCadastroDto.imovelId())
//                .orElseThrow(() -> new MoradorNaoExisteException("Imovel não encontrado"));
//
//        usuario.setImovel(imovel);


        Usuario usuarioSalvo = usuarioRepository.save(usuario);


        return new UsuarioExibicaoDto(usuarioSalvo);


//        Morador morador = new Morador();
//        BeanUtils.copyProperties(moradorCadastroDto, morador);
//        Imovel imovel = imovelRepository.findById(moradorCadastroDto.imovelId())
//                .orElseThrow(() -> new MoradorNaoExisteException("Imovel não encontrado"));
//
//        morador.setImovel(imovel);
//        return new MoradorExibicaoDto(moradorRepository.save(morador));
    }

    @Transactional(readOnly = true)
    public UsuarioExibicaoDto buscar(Long id) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);


        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoExisteException("Usuário não encontrado.");
        }
    }

    @Transactional
    public Usuario atualizar(Usuario usuario) {

        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(usuario.getId());

        if(usuarioOptional.isPresent()){
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }

////        Morador morador = moradorRepository.findById(moradorCadastroDto.id())
////                .orElseThrow(() -> new MoradorNaoExisteException("Morador não encontrado."));
////        BeanUtils.copyProperties(moradorCadastroDto, morador);
//
//        Imovel imovel = imovelRepository.findById(moradorCadastroDto.imovelId())
//                .orElseThrow(() -> new ImovelNaoExisteException("Imovel não encontrado"));
//        morador.setImovel(imovel);
//        return new MoradorExibicaoDto(moradorRepository.save(morador));
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new UsuarioNaoExisteException("Usuário não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioExibicaoDto> listarUsuarios() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }
}
