package co.com.bancolombia.certificacion.runners.manual_form;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/manual_form/collection_front.feature",
        glue = {"co.com.bancolombia.certificacion.stepdefinitions.manual_form"},
        tags = "",
        snippets = SnippetType.CAMELCASE
)
public class CollectionFrontRunner {
}
