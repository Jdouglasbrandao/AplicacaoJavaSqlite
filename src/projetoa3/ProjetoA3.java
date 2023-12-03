package projetoa3;

import br.com.login.controller.LoginController;
import br.com.login.view.LoginView;

public class ProjetoA3 {

    private LoginView loginView;

    public ProjetoA3() {
        loginView = new LoginView();
    }

    public void iniciarProjetoA3() {
        java.awt.EventQueue.invokeLater(() -> {
            loginView.setVisible(true);
        });

        LoginController loginController = new LoginController();

        loginView.getjButtonEntrar().addActionListener(e -> {
            boolean loginBemSucedido = loginController.loginUsuario(loginView);

            if (loginBemSucedido) {
                loginView.setVisible(false);
                // Adicione aqui a lógica para exibir outras telas ou realizar outras ações pós-login
            }
        });
    }

    public static void main(String[] args) {
        ProjetoA3 projetoA3 = new ProjetoA3();
        projetoA3.iniciarProjetoA3();
    }
}
