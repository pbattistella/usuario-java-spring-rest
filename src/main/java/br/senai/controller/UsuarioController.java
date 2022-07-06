package br.senai.controller;

import br.senai.model.Usuario;
import br.senai.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> findById(@PathVariable long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @PutMapping("/usuario/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable long id){
        return usuarioService.update(usuario, id);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable long id){
        usuarioService.delete(id);
    }
}
