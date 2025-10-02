package co.com.siigo.certificacion.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/modificar_carrito.feature",
        glue = "co.com.siigo.certificacion.stepdefinitions",
        snippets = CAMELCASE)
public class ModificarCarrito {
}
