package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UsuarioController {

    public boolean autenticar(String usuario, String senha) {
        String sql = "SELECT * from TBUSUARIO"
                + " WHERE email = ? and senha = ?"
                + " and ativo = true";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variavel(?)
            comando.setString(1, usuario);
            comando.setString(2, senha);

            //executa o comando e guarda o resultado da consulta
            resultado = comando.executeQuery();

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            if (resultado.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        
        return false;
    }
}
