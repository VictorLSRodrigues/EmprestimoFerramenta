package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Devolução;

public class DevoluçãoDAO {
    
    public static ArrayList<Devolução> listaDevolução = new ArrayList<>();

    public ArrayList<Devolução> getListaDevolução() {
        listaDevolução.clear();
        try {
            Statement stmt = getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_devoluções");
            while (res.next()) {
                int id = res.getInt("id");
                String nomeAmigo = res.getString("nomeAmigo");
                String data = res.getString("data");
                String nomeDaFerramenta = res.getString("nomeDaFerramenta");
                int idFerramenta = res.getInt("idFerramenta");

                Devolução devolução = new Devolução(nomeAmigo, idFerramenta, data, id, nomeDaFerramenta);
                listaDevolução.add(devolução);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return listaDevolução;
    }

    public Connection getConexao() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "emprestimodeferramentas";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "Unisul@1520";

            connection = DriverManager.getConnection(url, user, password);
            if (connection!= null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }

    public boolean insertDevoluçãoBD(Devolução devolução) {
        String sql = "INSERT INTO tb_devoluções (nomeAmigo, idFerramenta, data,id, nomeDaFerramenta) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = this.getConexao();
            if (connection == null) {
                throw new SQLException("Não foi possível conectar ao banco de dados.");
            }
            String sqlUltimoId = "SELECT MAX(id) AS max_id FROM tb_devoluções";
            Statement stmtUltimoId = connection.createStatement();
            ResultSet rsUltimoId = stmtUltimoId.executeQuery(sqlUltimoId);
            int ultimoId = 0;
            if (rsUltimoId.next()) {
                ultimoId = rsUltimoId.getInt("max_id");
            }
            rsUltimoId.close();
            stmtUltimoId.close();
            
            int novoId = ultimoId + 1;

            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, devolução.getNomeAmigo());
            stmt.setInt(2, devolução.getIdFerramenta());
            stmt.setString(3, devolução.getData());
            stmt.setInt(4, novoId);
            stmt.setString(5, devolução.getNomeDaFerramentaD());

            stmt.executeUpdate();
            stmt.close();
            connection.close();
            
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
}
