package steps;

import pages.LoginPage;
import utils.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Dado("que estou na página de login do OrangeHRM")
    public void que_estou_na_página_de_login_do_orange_hrm() {
        
    	loginPage.navegarParaPaginaLogin(); // Usa o método da LoginPage
    	
    }

    @Quando("eu preencho o usuário e a senha")
    public void eu_preencho_o_usuário_e_a_senha() throws Throwable {
        loginPage.preencherUsuario("Admin");
        loginPage.preencherSenha("admin123");
    }

    @Quando("clico no botão de login")
    public void clico_no_botão_de_login() throws Throwable {
        loginPage.clicarBotaoLogin();
    }

    @Entao("eu devo ser redirecionado para a página")
    public void eu_devo_ser_redirecionado_para_a_página_inicial() {
        loginPage.validarUrl("dashboard");
    }
}