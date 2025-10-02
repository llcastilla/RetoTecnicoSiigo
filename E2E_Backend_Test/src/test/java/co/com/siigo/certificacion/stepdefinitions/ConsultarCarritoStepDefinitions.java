package co.com.siigo.certificacion.stepdefinitions;

import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultarCarritoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado desea obtener la información de su carrito")
    public void queUnClienteAutenticadoDeseaObtenerLaInformaciónDeSuCarrito() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_CARRITO));

    }

    @When("se realiza una solicitud GET al endpoint de carrito")
    public void seRealizaUnaSolicitudGETAlEndpointDeCarrito() {
        actor.attemptsTo(ConnectUser.alServicio());

    }

    @Then("el servicio responde con el código de estado exitoso y los datos del carrito solicitado")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYLosDatosDelCarritoSolicitado() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }
}
