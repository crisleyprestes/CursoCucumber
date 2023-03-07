package br.com.linhares.crisley.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"br.com.linhares.crisley.steps", "br.com.linhares.crisley.config"},
        tags = {"@Unitários", "not @Ignore"},
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = false,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
        )
public class RunnerUnitTest {
}
