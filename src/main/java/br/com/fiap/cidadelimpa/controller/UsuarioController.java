package br.com.fiap.cidadelimpa.controller;


import br.com.fiap.cidadelimpa.dto.UsuarioCadastroDto;
import br.com.fiap.cidadelimpa.dto.UsuarioExibicaoDto;
import br.com.fiap.cidadelimpa.model.Usuario;
import br.com.fiap.cidadelimpa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // Endpoint para cadastrar contato
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto gravar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return service.gravar(usuarioCadastroDto);
    }
    // Endpoint para buscar pelo ID (cuidado para não dar ambiguidade com buscar pelo nome)
    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarPeloId(@PathVariable Long id){
        return service.buscarPeloId(id);
    }
    // Endpoint listar todos os contatos
    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioExibicaoDto> listarTodosOsUsuarios(Pageable paginacao){
        return service.listarTodosOsUsuarios(paginacao);
    }
    // Endpoint para deletar contato
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
    // Endpoint para atualizar contatos
    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return service.atualizar(usuario);
    }
    // Endpoint com diretório modificado para não dar ambiguidade com o buscar pelo ID
//    @GetMapping("/contatos/nome/{nome}")
//    @ResponseStatus(HttpStatus.OK)
//    public ContatoExibicaoDto buscarContatoPeloNome(@PathVariable String nome){
//        return service.buscarPeloNome(nome);
//    }

    // Endpoint usando QUERY com diretório modificado para não dar ambiguidade com o buscar pelo ID
    //api/contato?nome=Adriano Kim11
    @GetMapping(value = "/usuarios", params = "nome")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarUsuarioPeloNome(@RequestParam String nome){
        return service.buscarPeloNome(nome);
    }

    //Endpoint para consulta por email
    //api/contatos?email=email@email.com.br
    // Verificar depois
//    @GetMapping(value = "/contatos", params = "email")
//    @ResponseStatus(HttpStatus.OK)
//    public UsuarioExibicaoDto buscarUsuarioPeloEmail(@RequestParam String email){
//        return service.buscarUsuarioPeloEmail(email);
//    }




}

