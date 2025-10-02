package co.com.siigo.certificacion.stepdefinitions;

import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.DeleteClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarCarritoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado tiene un carrito existente para eliminar")
    public void queUnClienteAutenticadoTieneUnCarritoExistenteParaEliminar() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_CARRITO_DEL));

    }

    @When("se realiza una solicitud DELETE al endpoint de carrito")
    public void seRealizaUnaSolicitudDELETEAlEndpointDeCarrito() {
        actor.attemptsTo(DeleteClass.alServicio());

    }

    @Then("el servicio responde con el código de estado exitoso y el carrito se elimina correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElCarritoSeEliminaCorrectamente() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_SERVICIO_OK)));

    }
}
