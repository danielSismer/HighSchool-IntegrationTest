package repository;

import model.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository {

    Usuario save(Usuario user) throws SQLException;
    boolean delete(int id) throws SQLException;
    Usuario searchByID(Usuario u ) throws SQLException;
}
