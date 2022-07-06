package br.senai.service;

import br.senai.model.Usuario;
import br.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario create(Usuario newUsuario) {
        return usuarioRepository.save(newUsuario);
    }

    @Override
    public Usuario update(Usuario updatedUsuario, long id) {
        return usuarioRepository.findById(id)
                .map(u -> {
                    u.setNome(updatedUsuario.getNome());
                    u.setUsername(updatedUsuario.getUsername());
                    u.setSenha(updatedUsuario.getSenha());
                    return usuarioRepository.save(u);
                })
                .orElseGet(() ->{
                    updatedUsuario.setId(id);
                    return  usuarioRepository.save(updatedUsuario);
                });
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
}
