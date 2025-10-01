package co.com.bancolombia.certificacion.gestioninformacioncliente.models.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consultar_procedure.feature",
        glue = "co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions",
        snippets = CAMELCASE)
public class ConsultarProcedure {
}
