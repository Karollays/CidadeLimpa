package br.com.fiap.cidadelimpa.controller;

import br.com.fiap.cidadelimpa.dto.UsuarioCadastroDto;
import br.com.fiap.cidadelimpa.dto.UsuarioExibicaoDto;
import br.com.fiap.cidadelimpa.model.Usuario;
import br.com.fiap.cidadelimpa.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return usuarioService.salvar(usuarioCadastroDto);
    }

    @GetMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscar(@PathVariable Long usuarioId) {

        return usuarioService.buscar(usuarioId);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody @Valid Usuario usuario) {
        return usuarioService.atualizar(usuario);
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long usuarioId) {

        usuarioService.deletar(usuarioId);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> litarUsuarios() {

        return usuarioService.listarUsuarios();
    }
}
