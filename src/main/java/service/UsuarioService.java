package service;

import model.Usuario;

import java.sql.SQLException;

public interface UsuarioService {

    Usuario saveUser(Usuario u ) throws SQLException;
    boolean delete(Usuario usuario) throws SQLException;
    Usuario searchByID(Usuario u) throws SQLException;

}
