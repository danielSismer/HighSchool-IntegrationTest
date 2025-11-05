package service;

import model.Usuario;

import java.sql.SQLException;

public interface UsuarioService {

    Usuario saveUser(Usuario u ) throws SQLException;

}
