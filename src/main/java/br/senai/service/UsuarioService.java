package br.senai.service;

import br.senai.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> findAll();
    public Optional<Usuario> findById(long id);
    public Usuario create(Usuario newUsuario);
    public Usuario update(Usuario updatedUsuario, long id);
    public void delete(long id);
}
