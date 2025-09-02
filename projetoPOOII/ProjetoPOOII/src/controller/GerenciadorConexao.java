package controller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GerenciadorConexao {

    private static final String URL = "jbc:myqsl://127.0.0.1:3306/dbprojeto";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection conexao;

    public GerenciadorConexao() {
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
    }

    public PreparedStatement prepararComando(String sql) {

        PreparedStatement comando = null;

        {
            try {
                comando = conexao.prepareStatement(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao preparar conexão deu" + erro);
            }

            return comando;
        }
    }
}
