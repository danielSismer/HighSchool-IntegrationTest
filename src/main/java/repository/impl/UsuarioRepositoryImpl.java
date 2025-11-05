package repository.impl;

import config.DatabaseConnection;
import model.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

import javax.xml.crypto.Data;
import java.sql.*;

public class UsuarioRepositoryImpl implements UsuarioRepository {


    @Override
    public Usuario save(Usuario user) throws SQLException {
        String query = """
                INSERT INTO usuario (nome, cpf, telefone) 
                VALUES (?, ?, ?)
                """;
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCpf());
            stmt.setString(3, user.getTelefone());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                user.setId(rs.getInt(1));
            } else {
                return null;
            }
        }
        return user;
    }
}
