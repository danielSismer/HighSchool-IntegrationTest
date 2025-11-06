
import config.DatabaseConnection;
import model.Usuario;
import org.junit.jupiter.api.*;
import service.impl.UsuarioServiceImpl;

import javax.crypto.spec.PSource;
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste de Integração!!!")
public class UsuarioServiceIntegrationTest {


    UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

    private static final String SQL_CREATE_TABLE = """
            CREATE TABLE usuario (
            id int primary key auto_increment,
            nome VARCHAR(255) not null,
            cpf VARCHAR (11) not null,
            telefone VARCHAR(15) not null
            );
            """;

    private static final String SQL_DROP_TABLE = """
            DROP TABLE IF EXISTS usuario
            """;

    private static final String SQL_TRUNCATE_TABLE = """
            TRUNCATE TABLE usuario;
            """;

    @BeforeAll
    static void setubDatabase() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();

            stmt.execute(SQL_DROP_TABLE);
            stmt.execute(SQL_CREATE_TABLE);
            System.out.println("Tabela Usuário criada com sucesso!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void tearDownDatabase() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.execute(SQL_DROP_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void clearData() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();

            stmt.execute(SQL_TRUNCATE_TABLE);
        }
    }

   @Test
   @DisplayName("Retorna um usuário após salvar no banco!!!")
    void testSaveUSer() throws SQLException {

       Usuario usuario = new Usuario("Daniel Vinicius Rios Sismer", "17612810271", "5547997663268");
       usuario = usuarioService.saveUser(usuario);
       assertNotNull(usuario);

    }

    @Test
    @DisplayName("Retorna o true se o usuário foi deletado com sucesso!!!")
    void testDeleteUser() throws SQLException {

        Usuario usuario = new Usuario("Isabelly da Silva Marques", "12", "");
        boolean verified = usuarioService.delete(usuario);
        assertNotNull(verified);

    }

    @Test
    @DisplayName("Retorna um usuário com um ID especificado!!!")
    void testBuscarPorID() throws SQLException {

        Usuario usuario = new Usuario("Isabelly da Silva Marques", "12", "");
        usuario = usuarioService.

    }

}
