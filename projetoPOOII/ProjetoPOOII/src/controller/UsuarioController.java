    package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class UsuarioController {

    public boolean autenticar(String email, String senha) {
        String sql = "SELECT * FROM tbusuario WHERE email = ? AND senha = ? AND ativo = true";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, email);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return false;
    }

    public boolean inserir(Usuario usu) {
        String sql = "INSERT INTO tbusuario (nome, email, senha, datanasc, ativo) VALUES (?, ?, ?, ?, ?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, usu.getNome());
            comando.setString(2, usu.getEmail());
            comando.setString(3, usu.getSenha());
            comando.setDate(4, new java.sql.Date(usu.getDatanasc().getTime()));
            comando.setBoolean(5, usu.isAtivo());

            comando.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }

        return false;
    }

    public List<Usuario> consultar() {
        String sql = "SELECT * FROM tbusuario";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> lista = new ArrayList<>();

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Usuario usu = new Usuario();
                usu.setPkusuario(resultado.getInt("pkusuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setDatanasc(resultado.getDate("datanasc"));
                usu.setAtivo(resultado.getBoolean("ativo"));

                lista.add(usu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuários: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }
}
