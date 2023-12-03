package br.com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection getConnection() throws SQLException {
        Connection conexao = null;

        try {
           
            Class.forName("org.sqlite.JDBC");

            
            String url = "jdbc:sqlite:bclogin.db";
            conexao = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        }

        return conexao;
    }
}