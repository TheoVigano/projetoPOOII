package model;

import java.util.Date;

/**
 * Representa um usuário do sistema.
 */
public class Usuario {

    private int pkusuario;         // Chave primária
    private String nome;           // Nome completo
    private String email;          // E-mail único
    private String senha;          // Senha de acesso
    private Date datanasc;         // Data de nascimento
    private boolean ativo;         // Status de ativação

    // Construtor padrão
    public Usuario() {
    }

    // Construtor completo
    public Usuario(int pkusuario, String nome, String email, String senha, Date datanasc, boolean ativo) {
        this.pkusuario = pkusuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.datanasc = datanasc;
        this.ativo = ativo;
    }

    // Getters e Setters
    public int getPkusuario() {
        return pkusuario;
    }

    public void setPkusuario(int pkusuario) {
        this.pkusuario = pkusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Retorna o status do usuário como texto.
     */
    public String getStatusTexto() {
        return ativo ? "Ativo" : "Inativo";
    }
}
