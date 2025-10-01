package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarUsuarioIdStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de consulta de usuarios está disponible")
    public void queElServicioDeConsultaDeUsuariosEstáDisponible() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_ROLES_ID));

    }

    @When("se realiza una solicitud GET al endpoint de usuarios por id")
    public void seRealizaUnaSolicitudGETAlEndpointDeUsuariosPorId() {
        actor.attemptsTo(ConnectUser.alServicio());

    }

    @Then("el servicio responde con el código de estado OK")
    public void elServicioRespondeConElCódigoDeEstadoOK() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }
}
