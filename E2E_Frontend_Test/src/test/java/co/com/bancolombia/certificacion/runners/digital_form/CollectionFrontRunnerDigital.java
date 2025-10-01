package co.com.bancolombia.certificacion.runners.digital_form;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/digital_form/collection_front_digital.feature",
        glue = {"co.com.bancolombia.certificacion.stepdefinitions.digital_form"},
        tags = "",
        snippets = SnippetType.CAMELCASE
)
public class CollectionFrontRunnerDigital {
}
