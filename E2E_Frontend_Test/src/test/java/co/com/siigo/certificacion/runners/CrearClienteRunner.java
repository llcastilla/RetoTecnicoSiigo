package co.com.siigo.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/digital_form/login.feature",
        glue = {"co.com.bancolombia.certificacion.stepdefinitions"},
        tags = "",
        snippets = SnippetType.CAMELCASE
)
public class CrearClienteRunner {
}
