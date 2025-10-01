package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GenerarTokenWebAdminStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que se requiere generar un token de autenticación para el admin")
    public void queSeRequiereGenerarUnTokenDeAutenticaciónParaElAdmin() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_TOKEN_ADMIN));

    }
    @When("se suministran las credenciales correspondientes del admin")
    public void seSuministranLasCredencialesCorrespondientesDelAdmin() {
        actor.attemptsTo(Consumer.elServicio(QUERYLOGIN));

    }
    @Then("se obtiene un token válido que puede ser utilizado para las consultas")
    public void seObtieneUnTokenVálidoQuePuedeSerUtilizadoParaLasConsultas() {
        actor.should(seeThatResponse("",response->response.statusCode(ESTADO_OK)));

    }

    @When("se suministran las credenciales incorrectas correspondientes del admin")
    public void seSuministranLasCredencialesIncorrectasCorrespondientesDelAdmin() {
        actor.attemptsTo(Consumer.elServicio(QUERYLOGINERROR));

    }

    @Then("se obtiene un mensaje indicando que no se puede logear")
    public void seObtieneUnMensajeIndicandoQueNoSePuedeLogear() {
        actor.should(seeThatResponse("",response->response.statusCode(ESTADO_SERVICIO_422)));

    }
}
