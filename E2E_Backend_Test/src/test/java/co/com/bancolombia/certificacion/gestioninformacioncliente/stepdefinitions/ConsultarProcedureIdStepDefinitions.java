package co.com.bancolombia.certificacion.gestioninformacioncliente.stepdefinitions;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectExistClientApi;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.ENDPOINT_PROCEDURES;
import static co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants.ESTADO_SERVICIO_OK;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarProcedureIdStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que un cliente autenticado desea obtener un procedimiento por su ID")
    public void queUnClienteAutenticadoDeseaObtenerUnProcedimientoPorSuID() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PROCEDURES));

    }

    @When("se realiza una solicitud GET al endpoint de procedimientos con un identificador válido")
    public void seRealizaUnaSolicitudGETAlEndpointDeProcedimientosConUnIdentificadorVálido() {
        actor.attemptsTo(ConnectUser.alServicio());

    }

    @Then("el servicio responde con el código de estado exitoso y los datos del procedimiento solicitado")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYLosDatosDelProcedimientoSolicitado() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }
}
