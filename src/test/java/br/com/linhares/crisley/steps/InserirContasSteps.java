package br.com.linhares.crisley.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("^que desejo adicionar uma conta$")
    public void queDesejoAdicionarUmaConta() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("crisley@mail.com");
        driver.findElement(By.id("senha")).sendKeys("123456");
        driver.findElement(By.xpath("//*[text()='Entrar']")).click();
        driver.findElement(By.cssSelector("div[class*='alert-success']")).isDisplayed();
        driver.findElement(By.xpath("//*[contains(text(), 'Contas')]")).click();
        driver.findElement(By.xpath("//*[text()='Adicionar']")).click();
    }

    @Quando("^adiciono uma conta válida$")
    public void adicionoAConta() {
        driver.findElement(By.id("nome")).sendKeys("Conta de teste");
        driver.findElement(By.xpath("//*[text()='Salvar']")).click();
    }

    @Quando("^adiciono a conta \"([^\"]*)\"$")
    public void adicionoAConta(String nomeConta) {
        driver.findElement(By.id("nome")).sendKeys(nomeConta);
        driver.findElement(By.xpath("//*[text()='Salvar']")).click();
    }

    @Então("^a conta é inserida com sucesso$")
    public void aContaÉInseridaComSucesso() {
        Assert.assertEquals("Conta adicionada com sucesso!",
                driver.findElement(By.cssSelector("div[class*='alert']")).getText());
    }

    @Então("^recebo a mensagem \"([^\"]*)\"$")
    public void receboA(String mensagem) {
        Assert.assertEquals(mensagem, driver.findElement(By.cssSelector("div[class*='alert']")).getText());
    }

    @After(order = 1, value = "@Funcionais")
    public void takeScreenshot(Scenario cenario){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getId() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0, value = "@Funcionais")
    public void fecharBrowser(){
        driver.quit();
    }
}
