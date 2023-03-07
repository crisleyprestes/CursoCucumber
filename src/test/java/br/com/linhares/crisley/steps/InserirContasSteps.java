package br.com.linhares.crisley.steps;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String usuario) {
        driver.findElement(By.id("email")).sendKeys(usuario);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String senha) {
        driver.findElement(By.id("senha")).sendKeys(senha);
    }

    @Quando("^seleciono entrar$")
    public void selecionoEntrar() {
        driver.findElement(By.xpath("//*[text()='Entrar']")).click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() {
        Assert.assertEquals("Bem vindo, Crisley Linhares!",
                driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() {
        driver.findElement(By.xpath("//*[contains(text(), 'Contas')]")).click();
    }

    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() {
        driver.findElement(By.xpath("//*[text()='Adicionar']")).click();
    }

    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String nomeConta) {
        driver.findElement(By.id("nome")).sendKeys(nomeConta);
    }

    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() {
        driver.findElement(By.xpath("//*[text()='Salvar']")).click();
    }

    @Então("^recebo a mensagem \"([^\"]*)\"$")
    public void receboA(String mensagem) {
        Assert.assertEquals(mensagem, driver.findElement(By.cssSelector("div[class*='alert']")).getText());
    }

    @After
    public void fecharBrowser(){
        driver.quit();
    }
}
