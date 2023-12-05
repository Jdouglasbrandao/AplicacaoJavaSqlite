package br.com.login.controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
import projetoa3.Menu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {

    public void cadastroUsuario(CadastroView view) {
        try (Connection conexao = new Conexao().getConnection()) {
            LoginDAO cadastro = new LoginDAO();
            cadastro.cadastrarUsuario(
                    view.getjTextFieldNome().getText(),
                    view.getjTextFieldEmail().getText(),
                    view.getjPasswordFieldSenha().getText()
            );
            System.out.println("Usuário cadastrado com sucesso!");


            view.dispose();
            new LoginView().setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public boolean loginUsuario(LoginView view) {
        try (Connection conexao = new Conexao().getConnection()) {
            LoginDAO login = new LoginDAO();
            boolean loginBemSucedido = login.login(view.getjTextFieldLogin().getText(), view.getjPasswordFieldSenha().getText());

            if (loginBemSucedido) {
                System.out.println("Login bem-sucedido!");

       
                abrirJanelaPrincipal();

         
                view.dispose();

            } else {
                JOptionPane.showMessageDialog(view, "Login falhou. Verifique E-mail (Usuário) e senha ", "Livroteca - Erro de Login", JOptionPane.ERROR_MESSAGE);
            }

            return loginBemSucedido;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao realizar login: " + e.getMessage());
            return false;
        }
    }

    private void abrirJanelaPrincipal() {
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
