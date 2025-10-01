package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarProcedureStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado desea obtener información de los procedimientos registrados")
    public void queUnClienteAutenticadoDeseaObtenerInformaciónDeLosProcedimientosRegistrados() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PROCEDURES_ID));

    }


    @When("se realiza una solicitud GET al endpoint de procedimientos")
    public void seRealizaUnaSolicitudGETAlEndpointDeProcedimientos() {
        actor.attemptsTo(ConnectUser.alServicio());

    }

    @Then("el servicio responde con el código de estado exitoso procedimientos")
    public void elServicioRespondeConElCódigoDeEstadoExitosoProcedimientos() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }
}
