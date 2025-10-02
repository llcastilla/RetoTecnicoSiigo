package co.com.siigo.certificacion.stepdefinitions;


import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CrearCarritoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado desea crear un carrito")
    public void queUnClienteAutenticadoDeseaCrearUnCarrito() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_CARRITO));

    }

    @When("se realiza una solicitud POST al endpoint de carrito con la información requerida")
    public void seRealizaUnaSolicitudPOSTAlEndpointDeCarritoConLaInformaciónRequerida() {
        actor.attemptsTo(Consumer.elServicio(QUERYCARRITO));

    }

    @Then("el servicio responde con el código de estado exitoso y el carrito es creado correctamente")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYElCarritoEsCreadoCorrectamente() {
        actor.should(seeThatResponse("", response -> response.statusCode(ESTADO_OK)));

    }
}
