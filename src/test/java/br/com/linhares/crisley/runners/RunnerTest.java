package br.com.linhares.crisley.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/inserir_conta.feature"},
        glue = {"br.com.linhares.crisley.steps"},
        tags = {"~@Ignore"},
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
        )
public class RunnerTest {

        @BeforeClass
        public static void resetarBanco(){
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("https://seubarriga.wcaquino.me/");
                driver.findElement(By.id("email")).sendKeys("crisley@mail.com");
                driver.findElement(By.id("senha")).sendKeys("123456");
                driver.findElement(By.xpath("//*[text()='Entrar']")).click();
                driver.findElement(By.cssSelector("a[href*='reset']")).click();
                driver.quit();
        }
}
