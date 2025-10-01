package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectRol;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarRolesStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que un cliente autenticado desea obtener información de los roles registrados")
    public void queUnClienteAutenticadoDeseaObtenerInformaciónDeLosRolesRegistrados() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_ROLES));

    }
    @When("se realiza una solicitud GET al endpoint de roles")
    public void seRealizaUnaSolicitudGETAlEndpointDeRoles() {
        actor.attemptsTo(ConnectRol.alServicio());

    }

    @Then("el servicio responde con el código de estado exitoso roles")
    public void elServicioRespondeConElCódigoDeEstadoExitosoRoles() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }


}
