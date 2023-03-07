package br.com.linhares.crisley.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"br.com.linhares.crisley.steps", "br.com.linhares.crisley.config"},
        tags = {"@Funcionais", "not @Ignore"},
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
        )
public class RunnerFunctionalTest {

        @BeforeClass
        public static void resetarBanco(){
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("https://seubarriga.wcaquino.me/");
                driver.manage().window().maximize();
                driver.findElement(By.id("email")).sendKeys("crisley@mail.com");
                driver.findElement(By.id("senha")).sendKeys("123456");
                driver.findElement(By.xpath("//*[text()='Entrar']")).click();
                driver.findElement(By.cssSelector("a[href*='reset']")).click();
                driver.quit();
        }
}
