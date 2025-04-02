package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsLogin {

	@FindBy(name = "username")
    protected WebElement campoUsuario;

    @FindBy(name = "password")
    protected WebElement campoSenha;

    @FindBy(css = "button[type='submit']")
    protected WebElement botaoLogin;

	
}
