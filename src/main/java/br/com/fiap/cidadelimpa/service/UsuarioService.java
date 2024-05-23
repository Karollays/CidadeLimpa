package br.com.fiap.cidadelimpa.service;

import br.com.fiap.cidadelimpa.dto.UsuarioCadastroDto;
import br.com.fiap.cidadelimpa.dto.UsuarioExibicaoDto;
import br.com.fiap.cidadelimpa.exception.UsuarioNaoEncontradoException;
import br.com.fiap.cidadelimpa.model.Usuario;
import br.com.fiap.cidadelimpa.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto gravar(UsuarioCadastroDto usuarioCadastroDto){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);


        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioExibicaoDto(usuarioSalvo);
    }

    public UsuarioExibicaoDto buscarPeloId(Long id) {

        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }
    }

    public Page<UsuarioExibicaoDto> listarTodosOsUsuarios(Pageable paginacao){
        return usuarioRepository
                .findAll(paginacao)
                .map(UsuarioExibicaoDto::new);
    }

    public void excluir(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario atualizar(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if(usuarioOptional.isPresent()){
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }

    }

    public UsuarioExibicaoDto buscarPeloNome(String nome){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNome(nome);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }
    }
// Ajustar depois
//    public UsuarioExibicaoDto buscarContatoPeloEmail(String email){
//
//        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
//
//        if (usuarioOptional.isPresent()){
//            return new UsuarioExibicaoDto(usuarioOptional.get());
//        } else {
//            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
//        }
//
//    }
}