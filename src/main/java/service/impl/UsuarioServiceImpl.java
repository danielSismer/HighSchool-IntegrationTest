package service.impl;

import model.Usuario;
import repository.UsuarioRepository;
import repository.impl.UsuarioRepositoryImpl;
import service.UsuarioService;

import java.sql.SQLException;

public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();

    @Override
    public Usuario saveUser(Usuario u) throws SQLException {
        return usuarioRepository.save(u);
    }

    @Override
    public boolean delete(Usuario usuario) throws SQLException {
        return usuarioRepository.delete(usuario.getId());
    }

    @Override
    public Usuario searchByID(Usuario u) throws SQLException {
        return null;
    }

}
