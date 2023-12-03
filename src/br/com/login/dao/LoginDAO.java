package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean login(String email, String senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = new Conexao().getConnection();
            String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            return rs.next();

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conexao != null) conexao.close();
        }
    }

    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = new Conexao().getConnection();
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);

            stmt.executeUpdate();

        } finally {
            if (stmt != null) stmt.close();
            if (conexao != null) conexao.close();
        }
    }
}
