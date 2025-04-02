package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.ElementsLogin;
import helpers.ComandosComuns;
import utils.Urls; // Importe a classe Urls

public class LoginPage extends ElementsLogin {
	private WebDriver driver;
	private ComandosComuns cc;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.cc = new ComandosComuns(driver); // Inicializa a variável cc
		PageFactory.initElements(driver, this);
	}

	// Navega até a página de login.

	public void navegarParaPaginaLogin() {
		driver.get(Urls.LOGIN); // Usa a URL da classe Urls
	}

	public void preencherUsuario(String usuario) {

		cc.sendKeys(campoUsuario, usuario);
		
	}

	public void preencherSenha(String senha) {
		
		cc.sendKeys(campoSenha, senha);
	}

	public void clicarBotaoLogin() {
		
		//cc.click(botaoLogin);
		System.out.println("Clicando no botão de login...");
	    if (botaoLogin.isDisplayed() && botaoLogin.isEnabled()) {
	        System.out.println("Botão de login encontrado e habilitado.");
	        cc.click(botaoLogin);
	    } else {
	        System.out.println("Botão de login não está visível ou habilitado.");
	    }
		
	}

	public void validarUrl(String texto) {
		cc.verificarUrlContem(texto);
	}

	// Método útil para cenários que exigem login prévio)

	public void logar() throws Throwable {
		navegarParaPaginaLogin();
		preencherUsuario("Admin");
		preencherSenha("admin123");
		clicarBotaoLogin();
		validarUrl("dashboard");
	}
}