package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO Logincadastros (nome, email, Senha) VALUES (?,?,?)";  
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, email);
        statement.setString(3, senha);
        statement.execute();
        conexao.close();
    }

    public void login(String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, Senha FROM Logincadastros WHERE email = ? AND Senha = ?"; 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.println("Possui");
        } else {
            System.out.println("Não possui");
        }

        conexao.close();
    }
}
