package co.com.siigo.certificacion.stepdefinitions;


import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.ConsumerPatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static org.hamcrest.Matchers.*;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ModificarCarritoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado tiene un carrito existente")
    public void queUnClienteAutenticadoTieneUnCarritoExistente() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_CARRITO_PATCH));

    }

    @When("se realiza una solicitud PUT al endpoint de carrito con la información actualizada")
    public void seRealizaUnaSolicitudPUTAlEndpointDeCarritoConLaInformaciónActualizada() {
        actor.attemptsTo(ConsumerPatch.elServicio(QUERYCARRITO));

    }

    @Then("el servicio responde con el código de estado exitoso y el carrito se modifica correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElCarritoSeModificaCorrectamente() {
        actor.should(
                seeThatResponse("El servicio debe responder con 200 OK y devolver los datos del carrito modificado",
                        response -> response
                                .statusCode(ESTADO_SERVICIO_OK)
                                .body("id", notNullValue())
                                .body("userId", notNullValue())
                                .body("products", not(empty()))
                                .body("products[0].id", notNullValue())
                                .body("products[0].id", equalTo(1))
                )
        );
    }

}
