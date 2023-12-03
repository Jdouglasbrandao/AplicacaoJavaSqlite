package br.com.login.controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {

    public void cadastroUsuario(CadastroView view) {
        try (Connection conexao = new Conexao().getConnection()) {
            LoginDAO cadastro = new LoginDAO();
            cadastro.cadastrarUsuario(view.getjTextFieldNome().getText(), view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void loginUsuario(LoginView view) {
        try (Connection conexao = new Conexao().getConnection()) {
            LoginDAO login = new LoginDAO();
            login.login(view.getjTextFieldLogin().getText(), view.getjPasswordFieldSenha().getText());
            System.out.println("Login bem-sucedido!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao realizar login: " + e.getMessage());
        }
    }
}
