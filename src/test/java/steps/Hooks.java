package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class Hooks {
    private WebDriver driver;

    public Hooks() {
        this.driver = DriverManager.getDriver();
    }

    @Before
    public void antesDoCenario(Scenario scenario) {
        // Exibe o nome do cenário no console
        System.out.println("Iniciando cenário: " + scenario.getName());
    }

    @After
    public void depoisDoCenario(Scenario scenario) {
        // Captura um screenshot após cada cenário
        capturarScreenshot(scenario, "Screenshot após o cenário");

        // Exibe o status do cenário no console
        System.out.println("Cenário '" + scenario.getName() + "' finalizado com status: " + scenario.getStatus());

        // Fecha o navegador após o cenário
        DriverManager.quitDriver();
    }

    private void capturarScreenshot(Scenario scenario, String descricao) {
        try {
            // Captura o screenshot
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Anexa o screenshot ao relatório
            scenario.attach(screenshot, "image/png", descricao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}